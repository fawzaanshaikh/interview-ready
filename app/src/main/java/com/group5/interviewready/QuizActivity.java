package com.group5.interviewready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    /* ------------- Questions and Answers Area ------------- */
    private int question_number = 1;
    public static int result = 0;
    private final int QUESTION_NOS = 10;
    private final int ANSWER_NOS = 4;
    private final int QUESTION_SPACE = 1;
    private final int ANSWER_SPACE = 1;

    private String[][] question_answer_set = new String[QUESTION_NOS][QUESTION_SPACE + ANSWER_NOS + ANSWER_SPACE];


    /* ------------- XML Tags Declarations ------------- */
    // Declarations of XML Tags
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private Button study;
    private Button exit;


    /* ------------- Function definitions ------------- */
    // Initial definition of questions and options
    private void setQuestionsAndAnswers() {
        // Setting of questions
        question_answer_set[0][0] = "1";
        question_answer_set[1][0] = "2";
        question_answer_set[2][0] = "3";
        question_answer_set[3][0] = "4";
        question_answer_set[4][0] = "5";
        question_answer_set[5][0] = "6";
        question_answer_set[6][0] = "7";
        question_answer_set[7][0] = "8";
        question_answer_set[8][0] = "9";
        question_answer_set[9][0] = "10";

        // Setting of options
        question_answer_set[0][1] = "A"; question_answer_set[0][2] = "B"; question_answer_set[0][3] = "C"; question_answer_set[0][4] = "D";
        question_answer_set[1][1] = "A"; question_answer_set[1][2] = "B"; question_answer_set[1][3] = "C"; question_answer_set[1][4] = "D";
        question_answer_set[2][1] = "A"; question_answer_set[2][2] = "B"; question_answer_set[2][3] = "C"; question_answer_set[2][4] = "D";
        question_answer_set[3][1] = "A"; question_answer_set[3][2] = "B"; question_answer_set[3][3] = "C"; question_answer_set[3][4] = "D";
        question_answer_set[4][1] = "A"; question_answer_set[4][2] = "B"; question_answer_set[4][3] = "C"; question_answer_set[4][4] = "D";
        question_answer_set[5][1] = "A"; question_answer_set[5][2] = "B"; question_answer_set[5][3] = "C"; question_answer_set[5][4] = "D";
        question_answer_set[6][1] = "A"; question_answer_set[6][2] = "B"; question_answer_set[6][3] = "C"; question_answer_set[6][4] = "D";
        question_answer_set[7][1] = "A"; question_answer_set[7][2] = "B"; question_answer_set[7][3] = "C"; question_answer_set[7][4] = "D";
        question_answer_set[8][1] = "A"; question_answer_set[8][2] = "B"; question_answer_set[8][3] = "C"; question_answer_set[8][4] = "D";
        question_answer_set[9][1] = "A"; question_answer_set[9][2] = "B"; question_answer_set[9][3] = "C"; question_answer_set[9][4] = "D";

        // Setting the answers
        question_answer_set[0][5] = "A";
        question_answer_set[1][5] = "B";
        question_answer_set[2][5] = "C";
        question_answer_set[3][5] = "D";
        question_answer_set[4][5] = "A";
        question_answer_set[5][5] = "B";
        question_answer_set[6][5] = "C";
        question_answer_set[7][5] = "D";
        question_answer_set[8][5] = "A";
        question_answer_set[9][5] = "B";
    }

    // Setting text on buttons each time an iteration takes place
    private void setTextOnButtons(Button[] buttons) {
        for (int i = 1; i < 5; i++) {
            buttons[i - 1].setText(question_answer_set[question_number - 1][i]);
        }
    }

    // Set the question
    private void setQuestion() {
        final TextView question = (TextView) findViewById(R.id.tv_question);
        question.setText(question_answer_set[question_number - 1][0]);  // The first column of the question_answer_set matrix contains the questions
    }

    // Update the question
    private void updateQuestion() {
        final TextView question = (TextView) findViewById(R.id.tv_question);
        question.setText(question_answer_set[question_number - 1][0]);  // The first column of the question_answer_set matrix contains the questions
    }

    // Checking if the selected answer is correct
    private void checkCorrect(String option) {
        if (option == question_answer_set[question_number - 1][5])
            result++;
    }

    // Whenever an option button is clicked, the question number displayed must be incremented by one
    private void incrementQuestionNumber(int QUESTION_NOS) {
        if (question_number < QUESTION_NOS) {
            question_number++;
            final TextView ques_no = (TextView) findViewById(R.id.tv_question_number);
            ques_no.setText("Q. No.: " + question_number + " / 10");
        }
        else {
            Toast.makeText(this, "End of quiz", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(QuizActivity.this, ResultActivity.class));
            finish();
        }
    }

    // Driver code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Load the questions and answers
        setQuestionsAndAnswers();


        /* ----- XML elements definitions ----- */
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        Button[] buttons = new Button[]{option1, option2, option3, option4};

        exit = findViewById(R.id.btn_exit);


        /* ----- onClickListeners ----- */
        //while (question_number <= QUESTION_NOS) {
            // Update the question
            setQuestion();
            // Set the text on the buttons
            setTextOnButtons(buttons);

            // On clicking option buttons
            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkCorrect("A");
                    incrementQuestionNumber(QUESTION_NOS);
                    updateQuestion();
                }
            });
            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkCorrect("B");
                    incrementQuestionNumber(QUESTION_NOS);
                    updateQuestion();
                }
            });
            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkCorrect("C");
                    incrementQuestionNumber(QUESTION_NOS);
                    updateQuestion();
                }
            });
            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkCorrect("D");
                    incrementQuestionNumber(QUESTION_NOS);
                    updateQuestion();
                }
            });


            // On clicking exit button
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        //}
    }
}