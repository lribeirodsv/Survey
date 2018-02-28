package com.survey;

import android.app.ActionBar;
import android.database.sqlite.SQLiteDatabase;
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
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //region variables declaration
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
    private String resposta;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ1(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("1");

                //endregion

                //region q2

                if (q2.getText().toString().trim().length() > 0){

                    resposta = q2.getText().toString();

                    dbHelper.insertQ2(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("2");

                //endregion

                //region q3.1

                if (q31.getText().toString().trim().length() > 0){

                    resposta = q31.getText().toString();

                    dbHelper.insertQ31(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );
                }

                //endregion

                //region q3.2

                if (q32.getText().toString().trim().length() > 0){

                    resposta = q32.getText().toString();

                    dbHelper.insertQ32(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );
                }


                //endregion

                //region q3.3

                status = q33.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ33(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );
                }


                //endregion

                //region q4.1

                status = q41.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ41(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );
                }

                //endregion

                //region q4.2

                status = q42.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ42(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );
                }

                //endregion

                if ((q31.getText().toString().trim().length() == 0 && q32.getText().toString().trim().length() == 0 && q33.getCheckedRadioButtonId() == -1) && (q41.getCheckedRadioButtonId() == -1 && q42.getCheckedRadioButtonId() == -1)) {

                    naoResp.add("3.1");
                    naoResp.add("3.2");
                    naoResp.add("3.3");
                    naoResp.add("4.2");
                    naoResp.add("4.1");

                }

                //Conhecimentos Ambientais
                //region q5

                status = q5.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ5(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("5");

                //endregion

                //region q6
                status = cb1.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ6(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb2.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ6(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb3.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ6(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb4.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ6(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb5.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ6(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb6.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ6(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb7.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ6(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked() && !cb5.isChecked() && !cb6.isChecked() && !cb7.isChecked())
                    naoResp.add("6");

                //endregion

                //region q7
                status = cb8.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ7(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb9.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ7(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb10.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ7(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb11.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ7(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb12.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ7(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb13.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ7(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                if(!cb8.isChecked() && !cb9.isChecked() && !cb10.isChecked() && !cb11.isChecked() && !cb12.isChecked() && !cb13.isChecked())
                    naoResp.add("7");
                //endregion

                //region q8
                status = q8.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ8(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("8");
                //endregion

                //region q8.1
                status = cb14.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ8a(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb15.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ8a(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb16.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ8a(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb17.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ8a(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb18.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ8a(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb19.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ8a(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
                }

                status = cb20.getId();
                checkBox = (CheckBox) findViewById(status);

                if(checkBox.isChecked()){

                    dbHelper.insertQ8a(
                            currPesq,
                            checkBox.getText().toString(),
                            sqLiteDatabase
                    );
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
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ9(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("9");

                //endregion

                //region q10

                status = q10.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ10(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("10");

                //endregion

                //region q11

                status = q11.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ11(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("11");

                //endregion

                //region q12

                status = q12.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ12(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("12");

                //endregion

                //region q13

                status = q13.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ13(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("13");

                //endregion

                //region q14

                status = q14.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ14(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("14");

                //endregion

                //Percepcao do risco
                //region q15

                status = q15.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ15(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("15");

                //endregion

                //region q16

                status = q16.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ16(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("16");

                //endregion

                //region q17

                status = q17.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ17(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("17");

                //endregion

                //region q18

                status = q18.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ18(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("18");

                //endregion

                //region q19

                status = q19.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ19(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("19");

                //endregion

                //region q20

                status = q20.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ20(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("20");

                //endregion

                //region q21

                status = q21.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ21(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("21");

                //endregion

                //region q22

                status = q22.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ22(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("22");

                //endregion

                //region q23

                status = q23.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ23(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("23");

                //endregion

                //region q24

                status = q24.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ24(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("24");

                //endregion

                //region q25

                status = q25.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ25(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("25");

                //endregion

                //region q26

                status = q26.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ26(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("26");

                //endregion

                //region q27

                status = q27.getCheckedRadioButtonId();

                if(status != -1) {

                    radioButton = (RadioButton) findViewById(status);
                    resposta = radioButton.getText().toString();

                    dbHelper.insertQ27(
                            currPesq,
                            resposta,
                            sqLiteDatabase
                    );

                } else
                    naoResp.add("27");

                //endregion

                if(naoResp.isEmpty()) {
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

                    //Clear Survey
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


                    //Retorna ao topo
                    scrollView.post(new Runnable() {
                        public void run() {
                            scrollView.scrollTo(5, 0);
                        }
                    });
                } else {

                    Toast.makeText(MainActivity.this,
                            "A(s) pergunta(s) " + naoResp.toString() + " não foi(ram) respondida(s)!", Toast.LENGTH_LONG).show();

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

}
