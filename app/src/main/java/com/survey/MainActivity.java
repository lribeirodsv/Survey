package com.survey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Integer    status;
    private boolean    statusbool;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    private void addListenerOnButton() {

        //region innitialize variables

        q2  = (EditText)   findViewById(R.id.e1);
        q31 = (EditText)   findViewById(R.id.e2);
        q32 = (EditText)   findViewById(R.id.e3);

        q1  = (RadioGroup) findViewById(R.id.q1);
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
                radioButton = (RadioButton) findViewById(status);
                    Log.d("Q1", radioButton.getText().toString());
                //endregion

                //region q2
                String respq2 = q2.getText().toString();
                    Log.d("Q2", respq2);
                //endregion

                //region q3.1
                String respq31 = q31.getText().toString();
                    Log.d("Q3.1", respq31);
                //endregion

                //region q3.2
                String respq32 = q32.getText().toString();
                    Log.d("Q3.2", respq32);
                //endregion

                //region q3.3
                status = q33.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                    Log.d("Q3.3", radioButton.getText().toString());
                //endregion

                //region q4.1
                status = q41.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                    Log.d("Q4.1", radioButton.getText().toString());
                //endregion

                //region q4.2
                status = q42.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                    Log.d("Q4.2", radioButton.getText().toString());
                //endregion

                //Conhecimentos Ambientais
                //region q5
                status = q5.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                    Log.d("Q5", radioButton.getText().toString());
                //endregion

                //region q6
                status = cb1.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q6", checkBox.getText().toString());

                status = cb2.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q6", checkBox.getText().toString());

                status = cb3.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q6", checkBox.getText().toString());

                status = cb4.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q6", checkBox.getText().toString());

                status = cb5.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q6", checkBox.getText().toString());

                status = cb6.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q6", checkBox.getText().toString());

                status = cb7.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q6", checkBox.getText().toString());
                //endregion

                //region q7
                status = cb8.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q7", checkBox.getText().toString());

                status = cb9.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q7", checkBox.getText().toString());

                status = cb10.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q7", checkBox.getText().toString());

                status = cb11.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q7", checkBox.getText().toString());

                status = cb12.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q7", checkBox.getText().toString());

                status = cb13.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q7", checkBox.getText().toString());
                //endregion

                //region q8
                status = q8.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q8", radioButton.getText().toString());
                //endregion

                //region q8.1
                status = cb14.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q8.1", checkBox.getText().toString());

                status = cb15.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q8.1", checkBox.getText().toString());

                status = cb16.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q8.1", checkBox.getText().toString());

                status = cb17.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q8.1", checkBox.getText().toString());

                status = cb18.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q8.1", checkBox.getText().toString());

                status = cb19.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q8.1", checkBox.getText().toString());

                status = cb20.getId();
                checkBox = (CheckBox) findViewById(status);
                statusbool = checkBox.isChecked();
                if (statusbool == true)
                    Log.d("Q8.1", checkBox.getText().toString());
                //endregion

                //Práticas relacionadas a logistica revertsa e destinacao de medicamentos
                //region q9
                status = q9.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q9", radioButton.getText().toString());
                //endregion

                //region q10
                status = q10.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q10", radioButton.getText().toString());
                //endregion

                //region q11
                status = q11.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q11", radioButton.getText().toString());
                //endregion

                //region q12
                status = q12.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q12", radioButton.getText().toString());
                //endregion

                //region q13
                status = q13.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q13", radioButton.getText().toString());
                //endregion

                //region q14
                status = q14.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q14", radioButton.getText().toString());
                //endregion

                //Percepcao do risco
                //region q15
                status = q15.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q15", radioButton.getText().toString());
                //endregion

                //region q16
                status = q16.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q16", radioButton.getText().toString());
                //endregion

                //region q17
                status = q17.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q17", radioButton.getText().toString());
                //endregion

                //region q18
                status = q18.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q18", radioButton.getText().toString());
                //endregion

                //region q19
                status = q19.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q19", radioButton.getText().toString());
                //endregion

                //region q20
                status = q20.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q20", radioButton.getText().toString());
                //endregion

                //region q21
                status = q21.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q21", radioButton.getText().toString());
                //endregion

                //region q22
                status = q22.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q22", radioButton.getText().toString());
                //endregion

                //region q23
                status = q23.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q23", radioButton.getText().toString());
                //endregion

                //region q24
                status = q24.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q24", radioButton.getText().toString());
                //endregion

                //region q25
                status = q25.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q25", radioButton.getText().toString());
                //endregion

                //region q26
                status = q26.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q26", radioButton.getText().toString());
                //endregion

                //region q27
                status = q27.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(status);
                Log.d("Q27", radioButton.getText().toString());
                //endregion

                Toast.makeText(MainActivity.this,
                        "Pesquisa Salva com Sucesso! Te amo!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            //Pergunta 1:
            case R.id.r1:
                if (checked)
                    Log.d("Radio selected Q1", "Masculino");
                    break;

            case R.id.r2:
                if (checked)
                    Log.d("Radio selected Q1", "Feminino");
                    break;

            //Pergunta 2:
            // @+id/e1

            //Pergunta 3.1.
            // @+id/e2

            //Pergunta 3.2.
            // @+id/e3

            //Pergunta 3.3.
            case R.id.r3:
                if (checked)
                    Log.d("Radio selected Q3.3", "Sim");
                break;
            case R.id.r4:
                if (checked)
                    Log.d("Radio selected Q3.3", "Não");
                break;
            case R.id.r5:
                if (checked)
                    Log.d("Radio selected Q3.3", "Ainda terei");
                break;

            //Pergunta 4.1.
            case R.id.r6:
                if (checked)
                    Log.d("Radio selected Q4.1", "Ensino superior incompleto");
                break;
            case R.id.r7:
                if (checked)
                    Log.d("Radio selected Q4.1", "Ensino superior completo");
                break;
            case R.id.r8:
                if (checked)
                    Log.d("Radio selected Q4.1", "Especialização");
                break;
            case R.id.r9:
                if (checked)
                    Log.d("Radio selected Q4.1", "Mestrado");
                break;
            case R.id.r10:
                if (checked)
                    Log.d("Radio selected Q4.1", "Doutorado");
                break;

            //Pergunta 4.2.
            case R.id.r11:
                if (checked)
                    Log.d("Radio selected Q4.2", "Todas");
                break;
            case R.id.r12:
                if (checked)
                    Log.d("Radio selected Q4.2", "Algumas");
                break;
            case R.id.r13:
                if (checked)
                    Log.d("Radio selected Q4.2", "Nenhuma");
                break;
        }
    }

}
