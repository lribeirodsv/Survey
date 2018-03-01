package com.survey;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SqliteExporter {

    private static final String TAG = SqliteExporter.class.getSimpleName();

    public static final String DB_BACKUP_DB_VERSION_KEY = "Versão";
    public static final String DB_BACKUP_TABLE_NAME = "Tabela";

    public static String export(SQLiteDatabase db) throws IOException{

        if( !FileUtils.isExternalStorageWritable() ){
            throw new IOException("Cannot write to external storage");
        }

        File backupDir = new File(Environment.getExternalStorageDirectory() + "/MSurvey", "");
        if (!backupDir.exists())
        {
            backupDir.mkdirs();
        }

        String fileName = createBackupFileName();

        File backupFile = new File(backupDir, fileName);
        boolean success = backupFile.createNewFile();
        if(!success){
            backupFile.delete();
            boolean success2 = backupFile.createNewFile();
            if(!success2) {
                throw new IOException("Failed to create the backup file");
            }
        }

        List<String> tables = getTablesOnDataBase(db);
        Log.d(TAG, "Started to fill the backup file in " + backupFile.getAbsolutePath());
        long starTime = System.currentTimeMillis();
        writeCsv(backupFile, db, tables);
        long endTime = System.currentTimeMillis();
        Log.d(TAG, "Creating backup took " + (endTime - starTime) + "ms.");

        return backupFile.getAbsolutePath();
    }

    private static String createBackupFileName(){
        return "pesquisas.csv";
    }

    public static List<String> getTablesOnDataBase(SQLiteDatabase db){
        Cursor c = null;
        List<String> tables = new ArrayList<>();
        try{
            c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
            if (c.moveToFirst()) {
                while ( !c.isAfterLast() ) {
                    tables.add(c.getString(0));
                    c.moveToNext();
                }
            }
        }
        catch(Exception throwable){
            Log.e(TAG, "Could not get the table names from db", throwable);
        }
        finally{
            if(c!=null)
                c.close();
        }
        return tables;
    }

    private static void writeCsv(File backupFile, SQLiteDatabase db, List<String> tables){
        CSVWriter csvWrite = null;
        Cursor curCSV = null;
        try {
            csvWrite = new CSVWriter(new FileWriter(backupFile));
            writeSingleValue(csvWrite, DB_BACKUP_DB_VERSION_KEY + "=" + db.getVersion());
            for(String table: tables){
                writeSingleValue(csvWrite, DB_BACKUP_TABLE_NAME + "=" + table);
                curCSV = db.rawQuery("SELECT * FROM " + table,null);
                csvWrite.writeNext(curCSV.getColumnNames());
                while(curCSV.moveToNext()) {
                    int columns = curCSV.getColumnCount();
                    String[] columnArr = new String[columns];
                    for( int i = 0; i < columns; i++){
                        columnArr[i] = curCSV.getString(i);
                    }
                    csvWrite.writeNext(columnArr);
                }
            }
        }
        catch(Exception sqlEx) {
            Log.e(TAG, sqlEx.getMessage(), sqlEx);
        }finally {
            if(csvWrite != null){
                try {
                    csvWrite.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( curCSV != null ){
                curCSV.close();
            }
        }
    }

    private static void writeSingleValue(CSVWriter writer, String value){
        writer.writeNext(new String[]{value});
    }
}