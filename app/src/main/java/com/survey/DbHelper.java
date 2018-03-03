package com.survey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lucas on 22/10/2017.
 */

public class DbHelper extends SQLiteOpenHelper{

    //region VARIABLES

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "survey";

    public static final String CREATE_TABLE_PESQ =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.PESQ.TABLE_NAME +
                    "( " +
                    ContractQuestions.PESQ.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.PESQ.DATA + " text);";

    public static final String PINSERT_PESQ =
            "INSERT INTO " + ContractQuestions.PESQ.TABLE_NAME +
                    "( " +
                    ContractQuestions.PESQ.CODIGO + "," +
                    ContractQuestions.PESQ.DATA + " )" +
                    "VALUES (" + 1 + "," + System.currentTimeMillis() + ");";

    public static final String CREATE_TABLE_Q01 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q01.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q01.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q01.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q02 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q02.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q02.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q02.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q1 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q1.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q1.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q1.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q2 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q2.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q2.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q2.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q31 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q31.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q31.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q31.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q32 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q32.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q32.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q32.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q33 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q33.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q33.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q33.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q41 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q41.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q41.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q41.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q42 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q42.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q42.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q42.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q5 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q5.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q5.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q5.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q6 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q6.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q6.CODIGO + " integer," +
                    ContractQuestions.Q6.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q7 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q7.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q7.CODIGO + " integer," +
                    ContractQuestions.Q7.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q8 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q8.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q8.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q8.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q9 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q9.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q9.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q9.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q10 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q10.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q10.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q10.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q11 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q11.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q11.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q11.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q12 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q12.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q12.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q12.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q13 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q13.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q13.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q13.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q14 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q14.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q14.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q14.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q15 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q15.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q15.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q15.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q16 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q16.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q16.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q16.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q17 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q17.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q17.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q17.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q18 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q18.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q18.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q18.RESPOSTA + " text);";

    public static final String CREATE_TABLE_Q19 =
            "CREATE TABLE IF NOT EXISTS " + ContractQuestions.Q19.TABLE_NAME +
                    "( " +
                    ContractQuestions.Q19.CODIGO + " integer PRIMARY KEY," +
                    ContractQuestions.Q19.RESPOSTA + " text);";

    //endregion

    public DbHelper (Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
        Log.d("Database operations","Database created successfully");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_PESQ);
        Log.d("Database operations","Table PESQ created successfully");
        sqLiteDatabase.execSQL(PINSERT_PESQ);
        Log.d("Database operations","Table PESQ first insert");


        sqLiteDatabase.execSQL(CREATE_TABLE_Q01);
        Log.d("Database operations","Table Q01 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q02);
        Log.d("Database operations","Table Q02 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q1);
        Log.d("Database operations","Table Q1 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q2);
        Log.d("Database operations","Table Q2 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q31);
        Log.d("Database operations","Table Q31 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q32);
        Log.d("Database operations","Table Q32 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q33);
        Log.d("Database operations","Table Q33 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q41);
        Log.d("Database operations","Table Q41 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q42);
        Log.d("Database operations","Table Q42 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q5);
        Log.d("Database operations","Table Q5 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q6);
        Log.d("Database operations","Table Q6 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q7);
        Log.d("Database operations","Table Q7 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q8);
        Log.d("Database operations","Table Q8 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q9);
        Log.d("Database operations","Table Q9 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q10);
        Log.d("Database operations","Table Q10 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q11);
        Log.d("Database operations","Table Q11 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q12);
        Log.d("Database operations","Table Q12 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q13);
        Log.d("Database operations","Table Q13 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q14);
        Log.d("Database operations","Table Q14 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q15);
        Log.d("Database operations","Table Q15 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q16);
        Log.d("Database operations","Table Q16 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q17);
        Log.d("Database operations","Table Q17 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q18);
        Log.d("Database operations","Table Q18 created successfully");
        sqLiteDatabase.execSQL(CREATE_TABLE_Q19);
        Log.d("Database operations","Table Q19 created successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        Log.d("Database operations","Upgrading Database");
    }

    //region METHODS - INSERTS

    public void insertQ01 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q01.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q01.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q01.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q01 table");
    }

    public void insertQ02 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q02.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q02.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q02.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q02 table");
    }


    public void insertQ1 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q1.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q1.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q1.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q1 table");
    }

    public void insertQ2 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q2.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q2.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q2.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q2 table");
    }

    public void insertQ31 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q31.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q31.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q31.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q31 table");
    }

    public void insertQ32 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q32.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q32.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q32.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q32 table");
    }

    public void insertQ33 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q33.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q33.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q33.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q33 table");
    }

    public void insertQ41 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q41.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q41.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q41.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q41 table");
    }

    public void insertQ42 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q42.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q42.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q42.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q42 table");
    }

    public void insertQ5 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q5.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q5.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q5.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q5 table");
    }

    public void insertQ6 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q6.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q6.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q6.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q6 table");
    }

    public void insertQ7 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q7.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q7.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q7.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q7 table");
    }

    public void insertQ8 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q8.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q8.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q8.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q8 table");
    }

    public void insertQ9 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q9.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q9.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q9.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q9 table");
    }

    public void insertQ10 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q10.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q10.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q10.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q10 table");
    }

    public void insertQ11 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q11.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q11.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q11.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q11 table");
    }

    public void insertQ12 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q12.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q12.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q12.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q12 table");
    }

    public void insertQ13 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q13.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q13.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q13.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q13 table");
    }

    public void insertQ14 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q14.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q14.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q14.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q14 table");
    }

    public void insertQ15 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q15.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q15.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q15.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q15 table");
    }

    public void insertQ16 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q16.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q16.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q16.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q16 table");
    }

    public void insertQ17 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q17.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q17.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q17.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q17 table");
    }

    public void insertQ18 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q18.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q18.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q18.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q18 table");
    }

    public void insertQ19 (Integer codigo, String resposta, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.Q19.CODIGO, codigo);
        contentValues.put(ContractQuestions.Q19.RESPOSTA, resposta);

        long l = sqLiteDatabase.insert(ContractQuestions.Q19.TABLE_NAME, null,contentValues);
        Log.d("Database operations","One row inserted in Q19 table");
    }

    public void insertPESQ (Integer codigo, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ContractQuestions.PESQ.CODIGO, codigo);
        contentValues.put(ContractQuestions.PESQ.DATA, System.currentTimeMillis());

        long l = sqLiteDatabase.insert(ContractQuestions.PESQ.TABLE_NAME, null,contentValues);
        Log.d("Database operations","New survey created");
    }

    //endregion

    public int getCurrNuPesq(SQLiteDatabase sqLiteDatabase){

        String selectQuery = "SELECT MAX(CDPESQ) AS CDPESQ FROM TABPESQ";

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        int cdpesq = cursor.getInt(cursor.getColumnIndex("CDPESQ"));

        return cdpesq;
    }

}
