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
    private boolean    statusbool;
    private ArrayList<String> naoResp;
    private TextView   pesq;
    private ScrollView scrollView;
    private RadioGroup q1;
    private EditText   q2;
    private EditText   q31;
    private EditText   q32;
    private RadioGroup q33;
    private RadioGroup q41;
    private RadioGroup q42;
    private RadioGroup q5;
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
    private RadioGroup q20;
    private RadioGroup q21;
    private RadioGroup q22;
    private RadioGroup q23;
    private RadioGroup q24;
    private RadioGroup q25;
    private RadioGroup q26;
    private RadioGroup q27;

    //q6
    private CheckBox   cb1;
    private CheckBox   cb2;
    private CheckBox   cb3;
    private CheckBox   cb4;
    private CheckBox   cb5;
    private CheckBox   cb6;
    private CheckBox   cb7;

    //q7
    private CheckBox   cb8;
    private CheckBox   cb9;
    private CheckBox   cb10;
    private CheckBox   cb11;
    private CheckBox   cb12;
    private CheckBox   cb13;

    //q8.1
    private CheckBox   cb14;
    private CheckBox   cb15;
    private CheckBox   cb16;
    private CheckBox   cb17;
    private CheckBox   cb18;
    private CheckBox   cb19;
    private CheckBox   cb20;

    private RadioButton radioButton;
    private CheckBox checkBox;
    private Button finalizar;
    private String respostaq1;
    private String respostaq2;
    private String respostaq31;
    private String respostaq32;
    private String respostaq33;
    private String respostaq41;
    private String respostaq42;
    private String respostaq5;
    private String respostaq61;
    private String respostaq62;
    private String respostaq63;
    private String respostaq64;
    private String respostaq65;
    private String respostaq66;
    private String respostaq67;
    private String respostaq71;
    private String respostaq72;
    private String respostaq73;
    private String respostaq74;
    private String respostaq75;
    private String respostaq76;
    private String respostaq8;
    private String respostaq81;
    private String respostaq82;
    private String respostaq83;
    private String respostaq84;
    private String respostaq85;
    private String respostaq86;
    private String respostaq87;
    private String respostaq9;
    private String respostaq10;
    private String respostaq11;
    private String respostaq12;
    private String respostaq13;
    private String respostaq14;
    private String respostaq15;
    private String respostaq16;
    private String respostaq17;
    private String respostaq18;
    private String respostaq19;
    private String respostaq20;
    private String respostaq21;
    private String respostaq22;
    private String respostaq23;
    private String respostaq24;
    private String respostaq25;
    private String respostaq26;
    private String respostaq27;

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
        q1  = (RadioGroup) findViewById(R.id.q1);
        q2  = (EditText)   findViewById(R.id.e1);
        q31 = (EditText)   findViewById(R.id.e2);
        q32 = (EditText)   findViewById(R.id.e3);
        q33 = (RadioGroup) findViewById(R.id.q33);
        q41 = (RadioGroup) findViewById(R.id.q41);
        q42 = (RadioGroup) findViewById(R.id.q42);
        q5  = (RadioGroup) findViewById(R.id.q5);
        q8  = (RadioGroup) findViewById(R.id.q8);
        q9  = (RadioGroup) findViewById(R.id.q9);
        q10  = (RadioGroup) findViewById(R.id.q10);
        q11  = (RadioGroup) findViewById(R.id.q11);
        q12  = (RadioGroup) findViewById(R.id.q12);
        q13  = (RadioGroup) findViewById(R.id.q13);
        q14  = (RadioGroup) findViewById(R.id.q14);
        q15  = (RadioGroup) findViewById(R.id.q15);
        q16  = (RadioGroup) findViewById(R.id.q16);
        q17  = (RadioGroup) findViewById(R.id.q17);
        q18  = (RadioGroup) findViewById(R.id.q18);
        q19  = (RadioGroup) findViewById(R.id.q19);
        q20  = (RadioGroup) findViewById(R.id.q20);
        q21  = (RadioGroup) findViewById(R.id.q21);
        q22  = (RadioGroup) findViewById(R.id.q22);
        q23  = (RadioGroup) findViewById(R.id.q23);
        q24  = (RadioGroup) findViewById(R.id.q24);
        q25  = (RadioGroup) findViewById(R.id.q25);
        q26  = (RadioGroup) findViewById(R.id.q26);
        q27  = (RadioGroup) findViewById(R.id.q27);

        cb1 = (CheckBox)   findViewById(R.id.cb1);
        cb2 = (CheckBox)   findViewById(R.id.cb2);
        cb3 = (CheckBox)   findViewById(R.id.cb3);
        cb4 = (CheckBox)   findViewById(R.id.cb4);
        cb5 = (CheckBox)   findViewById(R.id.cb5);
        cb6 = (CheckBox)   findViewById(R.id.cb6);
        cb7 = (CheckBox)   findViewById(R.id.cb7);
        cb8 = (CheckBox)   findViewById(R.id.cb8);
        cb9 = (CheckBox)   findViewById(R.id.cb9);
        cb10 = (CheckBox)   findViewById(R.id.cb10);
        cb11 = (CheckBox)   findViewById(R.id.cb11);
        cb12 = (CheckBox)   findViewById(R.id.cb12);
        cb13 = (CheckBox)   findViewById(R.id.cb13);
        cb14 = (CheckBox)   findViewById(R.id.cb14);
        cb15 = (CheckBox)   findViewById(R.id.cb15);
        cb16 = (CheckBox)   findViewById(R.id.cb16);
        cb17 = (CheckBox)   findViewById(R.id.cb17);
        cb18 = (CheckBox)   findViewById(R.id.cb18);
        cb19 = (CheckBox)   findViewById(R.id.cb19);
        cb20 = (CheckBox)   findViewById(R.id.cb20);

        //endregion

        finalizar = (Button) findViewById(R.id.button);

        finalizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Identificação
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
                status = cb1.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq61 = checkBox.getText().toString();

                }

                status = cb2.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq62 = checkBox.getText().toString();

                }

                status = cb3.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq63 = checkBox.getText().toString();

                }

                status = cb4.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq64 = checkBox.getText().toString();

                }

                status = cb5.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq65 = checkBox.getText().toString();

                }

                status = cb6.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq66 = checkBox.getText().toString();

                }

                status = cb7.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq67 = checkBox.getText().toString();

                }

                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked() && !cb5.isChecked() && !cb6.isChecked() && !cb7.isChecked())
                    naoResp.add("6");

                //endregion

                //region q7
                status = cb8.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq71 = checkBox.getText().toString();

                }

                status = cb9.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq72 = checkBox.getText().toString();

                }

                status = cb10.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq73 = checkBox.getText().toString();

                }

                status = cb11.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq74 = checkBox.getText().toString();

                }

                status = cb12.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq75 = checkBox.getText().toString();

                }

                status = cb13.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq76 = checkBox.getText().toString();

                }

                if(!cb8.isChecked() && !cb9.isChecked() && !cb10.isChecked() && !cb11.isChecked() && !cb12.isChecked() && !cb13.isChecked())
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

                //region q8.1
                status = cb14.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq81 = checkBox.getText().toString();

                }

                status = cb15.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq82 = checkBox.getText().toString();

                }

                status = cb16.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq83 = checkBox.getText().toString();

                }

                status = cb17.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq84 = checkBox.getText().toString();

                }

                status = cb18.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq85 = checkBox.getText().toString();

                }

                status = cb19.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq86 = checkBox.getText().toString();

                }

                status = cb20.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    respostaq87 = checkBox.getText().toString();

                }

                RadioButton rb1;
                RadioButton rb2;
                rb1 = (RadioButton) findViewById(R.id.r19);
                rb2 = (RadioButton) findViewById(R.id.r20);

                if(!cb14.isChecked() && !cb15.isChecked() && !cb16.isChecked() && !cb17.isChecked() && !cb18.isChecked() && !cb19.isChecked() && !cb20.isChecked() && (rb1.isChecked() || rb2.isChecked()))
                    naoResp.add("8a");
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

                //region q20

                status = q20.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq20 = radioButton.getText().toString();

                } else
                    naoResp.add("20");

                //endregion

                //region q21

                status = q21.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq21 = radioButton.getText().toString();

                } else
                    naoResp.add("21");

                //endregion

                //region q22

                status = q22.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq22 = radioButton.getText().toString();

                } else
                    naoResp.add("22");

                //endregion

                //region q23

                status = q23.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq23 = radioButton.getText().toString();

                } else
                    naoResp.add("23");

                //endregion

                //region q24

                status = q24.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq24 = radioButton.getText().toString();

                } else
                    naoResp.add("24");

                //endregion

                //region q25

                status = q25.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq25 = radioButton.getText().toString();

                } else
                    naoResp.add("25");

                //endregion

                //region q26

                status = q26.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq26 = radioButton.getText().toString();

                } else
                    naoResp.add("26");

                //endregion

                //region q27

                status = q27.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    respostaq27 = radioButton.getText().toString();

                } else
                    naoResp.add("27");

                //endregion

                if(naoResp.isEmpty()) {

                    //region inserts
                    dbHelper.insertQ1 (currPesq,respostaq1 ,sqLiteDatabase);
                    dbHelper.insertQ2 (currPesq,respostaq2 ,sqLiteDatabase);
                    dbHelper.insertQ31(currPesq,respostaq31,sqLiteDatabase);
                    dbHelper.insertQ32(currPesq,respostaq32,sqLiteDatabase);
                    dbHelper.insertQ33(currPesq,respostaq33,sqLiteDatabase);
                    dbHelper.insertQ41(currPesq,respostaq41,sqLiteDatabase);
                    dbHelper.insertQ42(currPesq,respostaq42,sqLiteDatabase);
                    dbHelper.insertQ5 (currPesq,respostaq5 ,sqLiteDatabase);
                    dbHelper.insertQ6(currPesq,respostaq61,sqLiteDatabase);
                    dbHelper.insertQ6(currPesq,respostaq62,sqLiteDatabase);
                    dbHelper.insertQ6(currPesq,respostaq63,sqLiteDatabase);
                    dbHelper.insertQ6(currPesq,respostaq64,sqLiteDatabase);
                    dbHelper.insertQ6(currPesq,respostaq65,sqLiteDatabase);
                    dbHelper.insertQ6(currPesq,respostaq66,sqLiteDatabase);
                    dbHelper.insertQ6(currPesq,respostaq67,sqLiteDatabase);
                    dbHelper.insertQ7(currPesq,respostaq71,sqLiteDatabase);
                    dbHelper.insertQ7(currPesq,respostaq72,sqLiteDatabase);
                    dbHelper.insertQ7(currPesq,respostaq73,sqLiteDatabase);
                    dbHelper.insertQ7(currPesq,respostaq74,sqLiteDatabase);
                    dbHelper.insertQ7(currPesq,respostaq75,sqLiteDatabase);
                    dbHelper.insertQ7(currPesq,respostaq76,sqLiteDatabase);
                    dbHelper.insertQ8(currPesq,respostaq8,sqLiteDatabase);
                    dbHelper.insertQ8a(currPesq,respostaq81,sqLiteDatabase);
                    dbHelper.insertQ8a(currPesq,respostaq82,sqLiteDatabase);
                    dbHelper.insertQ8a(currPesq,respostaq83,sqLiteDatabase);
                    dbHelper.insertQ8a(currPesq,respostaq84,sqLiteDatabase);
                    dbHelper.insertQ8a(currPesq,respostaq85,sqLiteDatabase);
                    dbHelper.insertQ8a(currPesq,respostaq86,sqLiteDatabase);
                    dbHelper.insertQ8a(currPesq,respostaq87,sqLiteDatabase);
                    dbHelper.insertQ9(currPesq,respostaq9,sqLiteDatabase);
                    dbHelper.insertQ10(currPesq,respostaq10,sqLiteDatabase);
                    dbHelper.insertQ11(currPesq,respostaq11,sqLiteDatabase);
                    dbHelper.insertQ12(currPesq,respostaq12,sqLiteDatabase);
                    dbHelper.insertQ13(currPesq,respostaq13,sqLiteDatabase);
                    dbHelper.insertQ14(currPesq,respostaq14,sqLiteDatabase);
                    dbHelper.insertQ15(currPesq,respostaq15,sqLiteDatabase);
                    dbHelper.insertQ16(currPesq,respostaq16,sqLiteDatabase);
                    dbHelper.insertQ17(currPesq,respostaq17,sqLiteDatabase);
                    dbHelper.insertQ18(currPesq,respostaq18,sqLiteDatabase);
                    dbHelper.insertQ19(currPesq,respostaq19,sqLiteDatabase);
                    dbHelper.insertQ20(currPesq,respostaq20,sqLiteDatabase);
                    dbHelper.insertQ21(currPesq,respostaq21,sqLiteDatabase);
                    dbHelper.insertQ22(currPesq,respostaq22,sqLiteDatabase);
                    dbHelper.insertQ23(currPesq,respostaq23,sqLiteDatabase);
                    dbHelper.insertQ24(currPesq,respostaq24,sqLiteDatabase);
                    dbHelper.insertQ25(currPesq,respostaq25,sqLiteDatabase);
                    dbHelper.insertQ26(currPesq,respostaq26,sqLiteDatabase);
                    dbHelper.insertQ27(currPesq,respostaq27,sqLiteDatabase);

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
                    q1.clearCheck();
                    q2.setText("");
                    q31.setText("");
                    q32.setText("");
                    q33.clearCheck();
                    q41.clearCheck();
                    q42.clearCheck();
                    q5.clearCheck();
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                    cb4.setChecked(false);
                    cb5.setChecked(false);
                    cb6.setChecked(false);
                    cb7.setChecked(false);
                    cb8.setChecked(false);
                    cb9.setChecked(false);
                    cb10.setChecked(false);
                    cb11.setChecked(false);
                    cb12.setChecked(false);
                    cb13.setChecked(false);
                    q8.clearCheck();
                    cb14.setChecked(false);
                    cb15.setChecked(false);
                    cb16.setChecked(false);
                    cb17.setChecked(false);
                    cb18.setChecked(false);
                    cb19.setChecked(false);
                    cb20.setChecked(false);
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
                    q20.clearCheck();
                    q21.clearCheck();
                    q22.clearCheck();
                    q23.clearCheck();
                    q24.clearCheck();
                    q25.clearCheck();
                    q26.clearCheck();
                    q27.clearCheck();
                    respostaq1 = "";
                    respostaq2 = "";
                    respostaq31 = "";
                    respostaq32 = "";
                    respostaq33 = "";
                    respostaq41 = "";
                    respostaq42 = "";
                    respostaq5 = "";
                    respostaq61 = "";
                    respostaq62 = "";
                    respostaq63 = "";
                    respostaq64 = "";
                    respostaq65 = "";
                    respostaq66 = "";
                    respostaq67 = "";
                    respostaq71 = "";
                    respostaq72 = "";
                    respostaq73 = "";
                    respostaq74 = "";
                    respostaq75 = "";
                    respostaq76 = "";
                    respostaq8 = "";
                    respostaq81 = "";
                    respostaq82 = "";
                    respostaq83 = "";
                    respostaq84 = "";
                    respostaq85 = "";
                    respostaq86 = "";
                    respostaq87 = "";
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
                    respostaq20 = "";
                    respostaq21 = "";
                    respostaq22 = "";
                    respostaq23 = "";
                    respostaq24 = "";
                    respostaq25 = "";
                    respostaq26 = "";
                    respostaq27 = "";
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
