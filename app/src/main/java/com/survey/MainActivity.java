package com.survey;

import android.Manifest;
import android.app.ActionBar;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.checkSelfPermission;

public class MainActivity extends AppCompatActivity {

    //region variables declaration
    public static final int PERMISSION_REQUEST_CODE = 1;

    private Integer    currPesq;
    private Integer    status;
    private ArrayList<String> naoResp;
    private TextView   pesq;
    private ScrollView scrollView;

    private RadioGroup q01;
    private RadioGroup q02;
    private RadioGroup q1;
    private EditText   q2;
    private EditText   q31;
    private EditText   q32;
    private RadioGroup q33;
    private RadioGroup q41;
    private RadioGroup q42;
    private RadioGroup q5;
    private RadioGroup q6;
    private RadioGroup q7;
    private RadioGroup q8;
    private RadioGroup q9;
    private RadioGroup q10;
    private RadioGroup q11;
    private RadioGroup q12;
    private RadioGroup q13;
    private RadioGroup q14;
    private RadioGroup q15;
    private RadioGroup q16;
    private RadioGroup q17;
    private RadioGroup q18;
    private RadioGroup q19;

    //q7
    private CheckBox   cb71;
    private CheckBox   cb72;
    private CheckBox   cb73;
    private CheckBox   cb74;
    private CheckBox   cb75;
    private CheckBox   cb76;

    private RadioButton radioButton;
    private CheckBox checkBox;
    private Button finalizar;
    private String respostaq01 = "";
    private String respostaq02 = "";
    private String respostaq1 = "";
    private String respostaq2 = "";
    private String respostaq31 = "";
    private String respostaq32 = "";
    private String respostaq33 = "";
    private String respostaq41 = "";
    private String respostaq42 = "";
    private String respostaq5 = "";
    private String respostaq6 = "";
    private String respostaq71 = "";
    private String respostaq72 = "";
    private String respostaq73 = "";
    private String respostaq74 = "";
    private String respostaq75 = "";
    private String respostaq76 = "";
    private String respostaq8 = "";
    private String respostaq9 = "";
    private String respostaq10 = "";
    private String respostaq11 = "";
    private String respostaq12 = "";
    private String respostaq13 = "";
    private String respostaq14 = "";
    private String respostaq15 = "";
    private String respostaq16 = "";
    private String respostaq17 = "";
    private String respostaq18 = "";
    private String respostaq19 = "";

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            Log.v("Application control","Permission is granted");
        else {
            Log.v("Application control","Permission is not granted");
            isStoragePermissionGranted();
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("   MSurvey");

        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        naoResp = new ArrayList<String>();

        scrollView = (ScrollView) findViewById(R.id.sv);
        pesq = (TextView) findViewById(R.id.pesq);

        currPesq = dbHelper.getCurrNuPesq(sqLiteDatabase);
        pesq.setText("Pesquisa: "+currPesq.toString());

        addListenerOnButton(dbHelper, sqLiteDatabase);
    }

    private void addListenerOnButton(final DbHelper dbHelper, final SQLiteDatabase sqLiteDatabase) {

        //region variables initialization
        q01 = (RadioGroup) findViewById(R.id.r01);
        q02 = (RadioGroup) findViewById(R.id.r02);
        q1  = (RadioGroup) findViewById(R.id.r1);
        q2  = (EditText)   findViewById(R.id.e2);
        q31 = (EditText)   findViewById(R.id.e3_1);
        q32 = (EditText)   findViewById(R.id.e3_2);
        q33 = (RadioGroup) findViewById(R.id.r3_3);
        q41 = (RadioGroup) findViewById(R.id.r4_1);
        q42 = (RadioGroup) findViewById(R.id.r4_2);
        q5  = (RadioGroup) findViewById(R.id.r5);
        q6  = (RadioGroup) findViewById(R.id.r6);
        q8  = (RadioGroup) findViewById(R.id.r8);
        q9  = (RadioGroup) findViewById(R.id.r9);
        q10  = (RadioGroup) findViewById(R.id.r10);
        q11  = (RadioGroup) findViewById(R.id.r11);
        q12  = (RadioGroup) findViewById(R.id.r12);
        q13  = (RadioGroup) findViewById(R.id.r13);
        q14  = (RadioGroup) findViewById(R.id.r14);
        q15  = (RadioGroup) findViewById(R.id.r15);
        q16  = (RadioGroup) findViewById(R.id.r16);
        q17  = (RadioGroup) findViewById(R.id.r17);
        q18  = (RadioGroup) findViewById(R.id.r18);
        q19  = (RadioGroup) findViewById(R.id.r19);

        cb71 = (CheckBox)   findViewById(R.id.cb7_1);
        cb72 = (CheckBox)   findViewById(R.id.cb7_2);
        cb73 = (CheckBox)   findViewById(R.id.cb7_3);
        cb74 = (CheckBox)   findViewById(R.id.cb7_4);
        cb75 = (CheckBox)   findViewById(R.id.cb7_5);
        cb76 = (CheckBox)   findViewById(R.id.cb7_6);

        //endregion

        finalizar = (Button) findViewById(R.id.button);

        finalizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Identificação
                //region q01

                status = q01.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq01 = radioButton.getText().toString();

                } else
                    naoResp.add("01");

                //endregion

                //region q02

                status = q02.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq02 = radioButton.getText().toString();

                } else
                    naoResp.add("02");

                //endregion

                //region q1

                status = q1.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq1 = radioButton.getText().toString();

                } else
                    naoResp.add("1");

                //endregion

                //region q2

                if (q2.getText().toString().trim().length() > 0){

                    respostaq2 = q2.getText().toString();

                } else
                    naoResp.add("2");

                //endregion

                //region q3.1

                if (q31.getText().toString().trim().length() > 0){

                    respostaq31 = q31.getText().toString();

                }

                //endregion

                //region q3.2

                if (q32.getText().toString().trim().length() > 0){

                    respostaq32 = q32.getText().toString();

                }


                //endregion

                //region q3.3

                status = q33.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq33 = radioButton.getText().toString();

                }


                //endregion

                //region q4.1

                status = q41.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq41 = radioButton.getText().toString();

                }

                //endregion

                //region q4.2

                status = q42.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq42 = radioButton.getText().toString();

                }

                //endregion

                //region Validação Docente/Discente
                if ((q31.getText().toString().trim().length() == 0 || q32.getText().toString().trim().length() == 0 || q33.getCheckedRadioButtonId() == -1) && (q41.getCheckedRadioButtonId() == -1 || q42.getCheckedRadioButtonId() == -1)) {

                    naoResp.add("3.1");
                    naoResp.add("3.2");
                    naoResp.add("3.3");
                    naoResp.add("4.2");
                    naoResp.add("4.1");

                }
                //endregion

                //Conhecimentos Ambientais
                //region q5

                status = q5.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq5 = radioButton.getText().toString();

                } else
                    naoResp.add("5");

                //endregion

                //region q6

                status = q6.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq6 = radioButton.getText().toString();

                } else
                    naoResp.add("6");

                //endregion

                //region q7
                status = cb71.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq71 = checkBox.getText().toString();

                }

                status = cb72.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq72 = checkBox.getText().toString();

                }

                status = cb73.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq73 = checkBox.getText().toString();

                }

                status = cb74.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq74 = checkBox.getText().toString();

                }

                status = cb75.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq75 = checkBox.getText().toString();

                }

                status = cb76.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq76 = checkBox.getText().toString();

                }

                if(!cb71.isChecked() && !cb72.isChecked() && !cb73.isChecked() && !cb74.isChecked() && !cb75.isChecked() && !cb76.isChecked())
                    naoResp.add("7");
                //endregion

                //region q8
                status = q8.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq8 = radioButton.getText().toString();

                } else
                    naoResp.add("8");
                //endregion

                //Práticas relacionadas a logistica revertsa e destinacao de medicamentos
                //region q9

                status = q9.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq9 = radioButton.getText().toString();

                } else
                    naoResp.add("9");

                //endregion

                //region q10

                status = q10.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq10 = radioButton.getText().toString();

                } else
                    naoResp.add("10");

                //endregion

                //region q11

                status = q11.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq11 = radioButton.getText().toString();

                } else
                    naoResp.add("11");

                //endregion

                //region q12

                status = q12.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq12 = radioButton.getText().toString();

                } else
                    naoResp.add("12");

                //endregion

                //region q13

                status = q13.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq13 = radioButton.getText().toString();

                } else
                    naoResp.add("13");

                //endregion

                //region q14

                status = q14.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq14 = radioButton.getText().toString();

                } else
                    naoResp.add("14");

                //endregion

                //Percepcao do risco
                //region q15

                status = q15.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq15 = radioButton.getText().toString();

                } else
                    naoResp.add("15");

                //endregion

                //region q16

                status = q16.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq16 = radioButton.getText().toString();

                } else
                    naoResp.add("16");

                //endregion

                //region q17

                status = q17.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq17 = radioButton.getText().toString();

                } else
                    naoResp.add("17");

                //endregion

                //region q18

                status = q18.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq18 = radioButton.getText().toString();

                } else
                    naoResp.add("18");

                //endregion

                //region q19

                status = q19.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq19 = radioButton.getText().toString();

                } else
                    naoResp.add("19");

                //endregion

                if(naoResp.isEmpty()) {

                    //region inserts
                    dbHelper.insertQ01 (currPesq,respostaq01 ,sqLiteDatabase);
                    dbHelper.insertQ02 (currPesq,respostaq02 ,sqLiteDatabase);
                    dbHelper.insertQ1  (currPesq,respostaq1  ,sqLiteDatabase);
                    dbHelper.insertQ2  (currPesq,respostaq2  ,sqLiteDatabase);

                    if (!respostaq31.isEmpty()) {
                        dbHelper.insertQ31(currPesq, respostaq31, sqLiteDatabase);
                    }
                    if (!respostaq32.isEmpty()) {
                        dbHelper.insertQ32(currPesq, respostaq32, sqLiteDatabase);
                    }
                    if (!respostaq33.isEmpty()) {
                        dbHelper.insertQ33(currPesq, respostaq33, sqLiteDatabase);
                    }
                    if (!respostaq41.isEmpty()) {
                        dbHelper.insertQ41(currPesq, respostaq41, sqLiteDatabase);
                    }
                    if (!respostaq42.isEmpty()) {
                        dbHelper.insertQ42 (currPesq,respostaq42 ,sqLiteDatabase);
                    }

                    dbHelper.insertQ5  (currPesq,respostaq5  ,sqLiteDatabase);
                    dbHelper.insertQ6  (currPesq,respostaq6  ,sqLiteDatabase);

                    if (!respostaq71.isEmpty()){
                        dbHelper.insertQ7  (currPesq,respostaq71 ,sqLiteDatabase);
                    }
                    if (!respostaq72.isEmpty()) {
                        dbHelper.insertQ7(currPesq, respostaq72, sqLiteDatabase);
                    }
                    if (!respostaq73.isEmpty()) {
                        dbHelper.insertQ7(currPesq, respostaq73, sqLiteDatabase);
                    }
                    if (!respostaq74.isEmpty()) {
                        dbHelper.insertQ7(currPesq, respostaq74, sqLiteDatabase);
                    }
                    if (!respostaq75.isEmpty()) {
                        dbHelper.insertQ7(currPesq, respostaq75, sqLiteDatabase);
                    }
                    if (!respostaq76.isEmpty()){
                        dbHelper.insertQ7  (currPesq,respostaq76 ,sqLiteDatabase);
                    }

                    dbHelper.insertQ8  (currPesq,respostaq8  ,sqLiteDatabase);
                    dbHelper.insertQ9  (currPesq,respostaq9  ,sqLiteDatabase);
                    dbHelper.insertQ10 (currPesq,respostaq10 ,sqLiteDatabase);
                    dbHelper.insertQ11 (currPesq,respostaq11 ,sqLiteDatabase);
                    dbHelper.insertQ12 (currPesq,respostaq12 ,sqLiteDatabase);
                    dbHelper.insertQ13 (currPesq,respostaq13 ,sqLiteDatabase);
                    dbHelper.insertQ14 (currPesq,respostaq14 ,sqLiteDatabase);
                    dbHelper.insertQ15 (currPesq,respostaq15 ,sqLiteDatabase);
                    dbHelper.insertQ16 (currPesq,respostaq16 ,sqLiteDatabase);
                    dbHelper.insertQ17 (currPesq,respostaq17 ,sqLiteDatabase);
                    dbHelper.insertQ18 (currPesq,respostaq18 ,sqLiteDatabase);
                    dbHelper.insertQ19 (currPesq,respostaq19 ,sqLiteDatabase);

                    //endregion

                    Toast.makeText(MainActivity.this,
                            "Pesquisa " + currPesq + " salva com sucesso! Te amo!", Toast.LENGTH_SHORT).show();

                    //Insere Pesquisa Nova
                    dbHelper.insertPESQ(
                            currPesq + 1,
                            sqLiteDatabase
                    );
                    Log.d("Application Control", "New survey inserted");

                    //Atualiza Pesquisa
                    currPesq = dbHelper.getCurrNuPesq(sqLiteDatabase);
                    Log.d("Application Control", "New survey code: " + currPesq.toString());
                    pesq.setText("Pesquisa: " + currPesq.toString());

                    //region Clear Survey
                    q01.clearCheck();
                    q02.clearCheck();
                    q1.clearCheck();
                    q2.setText("");
                    q31.setText("");
                    q32.setText("");
                    q33.clearCheck();
                    q41.clearCheck();
                    q42.clearCheck();
                    q5.clearCheck();
                    q6.clearCheck();
                    cb71.setChecked(false);
                    cb72.setChecked(false);
                    cb73.setChecked(false);
                    cb74.setChecked(false);
                    cb75.setChecked(false);
                    cb76.setChecked(false);
                    q8.clearCheck();
                    q9.clearCheck();
                    q10.clearCheck();
                    q11.clearCheck();
                    q12.clearCheck();
                    q13.clearCheck();
                    q14.clearCheck();
                    q15.clearCheck();
                    q16.clearCheck();
                    q17.clearCheck();
                    q18.clearCheck();
                    q19.clearCheck();
                    respostaq01 = "";
                    respostaq02 = "";
                    respostaq1 = "";
                    respostaq2 = "";
                    respostaq31 = "";
                    respostaq32 = "";
                    respostaq33 = "";
                    respostaq41 = "";
                    respostaq42 = "";
                    respostaq5 = "";
                    respostaq6 = "";
                    respostaq71 = "";
                    respostaq72 = "";
                    respostaq73 = "";
                    respostaq74 = "";
                    respostaq75 = "";
                    respostaq76 = "";
                    respostaq8 = "";
                    respostaq9 = "";
                    respostaq10 = "";
                    respostaq11 = "";
                    respostaq12 = "";
                    respostaq13 = "";
                    respostaq14 = "";
                    respostaq15 = "";
                    respostaq16 = "";
                    respostaq17 = "";
                    respostaq18 = "";
                    respostaq19 = "";
                    //endregion

                    //Retorna ao topo
                    scrollView.post(new Runnable() {
                        public void run() {
                            scrollView.scrollTo(5, 0);
                        }
                    });

                    //Export .CSV
                    try {
                        SqliteExporter.export(sqLiteDatabase);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    Toast.makeText(MainActivity.this,
                            "A(s) pergunta(s) " + naoResp.toString().replace("[", "").replace("]", "") + " não foi(ram) respondida(s)!", Toast.LENGTH_LONG).show();

                    naoResp.clear();
                }
            }
        });
    }


    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

        }
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("Permition control","Permission is granted");
                return true;
            } else {

                Log.v("Permition control","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("Permition control","Permission is granted");
            return true;
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v("Permition control",permissions[0]+ " was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }
}
