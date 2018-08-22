package com.example.charles.quiz;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BlackHistory extends AppCompatActivity {

    CheckBox cbQuestionOneA, cbQuestionOneB, cbQuestionOneC;
    CheckBox cbQuestionTwoA, cbQuestionTwoB, cbQuestionTwoC;
    RadioButton rbOneQue3, rbTwoQue3, rbThreeQue3;
    Boolean blPartA, blPartB, blPartC, blPartD;
    RadioGroup rgQuestion;

    Integer intCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_history);

        blPartB = false;
        blPartA = false;
        blPartC = false;
        blPartD = false;


        Button btnSubmit = findViewById(R.id.btSubmitBH);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blPartA && blPartB) {
                    intCorrect++;
                }


                if (blPartC && blPartD) {
                    intCorrect++;
                }


                String str = MainActivity.strUserName;

                Resources res = getResources();
                String msg = res.getString(R.string.summaryMessage, str, intCorrect);


                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                toast.show();
                resetButtons();

            }
        });
        rbOneQue3 = findViewById(R.id.rbOneQue3);
        rbTwoQue3 = findViewById(R.id.rbTwoQue3);
        rbThreeQue3 = findViewById(R.id.rbThreeQue3);

        rgQuestion = findViewById(R.id.rgQuestionThree);
        rgQuestion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == rbTwoQue3.getId()) {
                    if (rbTwoQue3.isChecked())
                        intCorrect++;

                }

            }
        });
        cbQuestionTwoC = findViewById(R.id.chkbxQuestionTwoC);
        cbQuestionTwoC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                blPartD = !cbQuestionTwoB.isChecked() && isChecked;
            }
        });
        cbQuestionTwoB = findViewById(R.id.chkbxQuestionTwoB);
        cbQuestionTwoB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbQuestionTwoB.isChecked())
                    blPartC = false;
                blPartD = false;
            }
        });
        cbQuestionTwoA = findViewById(R.id.chkbxQuestionTwoA);
        cbQuestionTwoA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                blPartC = !cbQuestionTwoB.isChecked() && isChecked;
            }
        });
        cbQuestionOneB = findViewById(R.id.chkbxTwo);
        cbQuestionOneB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                blPartB = !cbQuestionOneC.isChecked() && isChecked;
            }
        });

        cbQuestionOneA = findViewById(R.id.chkbxOne);
        cbQuestionOneA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                blPartA = !cbQuestionOneC.isChecked() && isChecked;
            }
        });
        cbQuestionOneC = findViewById(R.id.chkbxThree);
        cbQuestionOneC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbQuestionOneC.isChecked())
                    blPartA = false;
                blPartB = false;
            }
        });


    }

    private void resetButtons() {
        cbQuestionTwoA.setChecked(false);
        cbQuestionTwoB.setChecked(false);
        cbQuestionTwoC.setChecked(false);
        cbQuestionOneA.setChecked(false);
        cbQuestionOneB.setChecked(false);
        cbQuestionOneC.setChecked(false);
        rgQuestion.clearCheck();
        intCorrect = 0;
    }
}



