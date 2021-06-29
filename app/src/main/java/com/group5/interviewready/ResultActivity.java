package com.group5.interviewready;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    // Declarations
    private Button exit;

    // Display the result on the text view
    private void displayResult() {
        final TextView result_tv = (TextView) findViewById(R.id.tv_result);
        Toast.makeText(this, "Score - " + QuizActivity.result, Toast.LENGTH_SHORT).show();
        result_tv.setText("Your score:\n" + QuizActivity.result + " / 10");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Display the result
        displayResult();

        // Definitions
        exit = (Button) findViewById(R.id.btn_exit_2);

        // When exit button is clicked
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}