package com.example.charles.quiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Chess extends AppCompatActivity {
    private int numberCorrect;
    private ViewFlipper vFChess;
    private RadioButton rb1QuestionOne, rb2QuestionOne, rb3QuestionOne;
    private RadioButton rb1QuestionTwo, rb2QuestionTwo, rb3QuestionTwo;
    private RadioButton rb3QuestionThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);

        final TextView tvOpenAnswer = findViewById(R.id.tvOpenAnswer);

        vFChess = findViewById(R.id.simpleViewer1);
        vFChess.setInAnimation(this, android.R.anim.fade_in);
        vFChess.setOutAnimation(this, android.R.anim.fade_out);

        RadioGroup rgQuestionOne = findViewById(R.id.rgChessQuestionOne);
        RadioGroup rgQuestionTwo = findViewById(R.id.rgChessQuestionTwo);
        RadioGroup rgQuestionThree = findViewById(R.id.rgChessQuestionThree);

        final EditText etOpenAnswer = findViewById(R.id.etOpenAnswer);


        setRadioButtons();

        Button btnSubmit = findViewById(R.id.btSubmitChess);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = MainActivity.strUserName;


                Resources res = getResources();
                String msg = res.getString(R.string.summaryMessage, str, numberCorrect);


                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                toast.show();
                numberCorrect = 0;


            }
        });


        //attach onClickListeners

        rgQuestionThree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == rb3QuestionThree.getId()) {
                    if (rb3QuestionThree.isChecked())
                        numberCorrect++;

                }

                vFChess.stopFlipping();

                LinearLayout llSummary = findViewById(R.id.lLChessSummary);
                llSummary.setVisibility(View.VISIBLE);

            }
        });

        rgQuestionTwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String strMsg;

                if (checkedId == rb1QuestionTwo.getId()) {

                    strMsg = "correct";
                    numberCorrect++;
                    Toast toast = Toast.makeText(getApplicationContext(), strMsg, Toast.LENGTH_SHORT);
                    toast.show();


                } else if (checkedId == rb2QuestionTwo.getId()) {
                    strMsg = "incorrect";

                    Toast toast2 = Toast.makeText(getApplicationContext(), strMsg, Toast.LENGTH_SHORT);
                    toast2.show();


                } else if (checkedId == rb3QuestionTwo.getId()) {
                    strMsg = "incorrect";

                    Toast toast3 = Toast.makeText(getApplicationContext(), strMsg, Toast.LENGTH_SHORT);
                    toast3.show();
                }
                vFChess.showNext();
            }
        });

        rgQuestionOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String strMsg;

                if (checkedId == rb1QuestionOne.getId()) {
                    strMsg = "incorrect";
                    Toast toast = Toast.makeText(getApplicationContext(), strMsg, Toast.LENGTH_SHORT);
                    toast.show();


                } else if (checkedId == rb2QuestionOne.getId()) {
                    strMsg = "correct";
                    numberCorrect++;
                    Toast toast2 = Toast.makeText(getApplicationContext(), strMsg, Toast.LENGTH_SHORT);
                    toast2.show();


                } else if (checkedId == rb3QuestionOne.getId()) {


                    strMsg = "incorrect";

                    Toast toast3 = Toast.makeText(getApplicationContext(), strMsg, Toast.LENGTH_SHORT);
                    toast3.show();
                }

                String strOpen = etOpenAnswer.getText().toString();
                if (strOpen.equalsIgnoreCase("stalemate")) {
                    numberCorrect++;
                }
                tvOpenAnswer.setVisibility(View.GONE);
                etOpenAnswer.setVisibility(View.GONE);
                vFChess.showNext();
            }
        });
    }

    private void setRadioButtons() {

        //question one radioButtons
        rb1QuestionOne = findViewById(R.id.rbOneChessQue1);
        rb2QuestionOne = findViewById(R.id.rbTwoChessQue1);
        rb3QuestionOne = findViewById(R.id.rbThreeChessQue1);

        //question two radioButtons
        rb1QuestionTwo = findViewById(R.id.rbOneChessQue2);
        rb2QuestionTwo = findViewById(R.id.rbTwoChessQue2);
        rb3QuestionTwo = findViewById(R.id.rbThreeChessQue2);

        //question three radioButtons

        rb3QuestionThree = findViewById(R.id.rbThreeChessQue3);

    }
}
