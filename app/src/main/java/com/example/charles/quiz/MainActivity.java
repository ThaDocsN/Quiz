package com.example.charles.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String strUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView[] questionCategory = new TextView[2];
        questionCategory[0] = findViewById(R.id.chess);
        questionCategory[1] = findViewById(R.id.blackHistory);

        questionCategory[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent blackHistoryIntent = new Intent(MainActivity.this, BlackHistory.class);
                getUserName();

                startActivity(blackHistoryIntent);
            }
        });

        questionCategory[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chessIntent = new Intent(MainActivity.this, Chess.class);
                getUserName();
                startActivity(chessIntent);
            }
        });


    }
    private void getUserName(){
        EditText ed = findViewById(R.id.editText);
        strUserName = ed.getText().toString();

    }
}
