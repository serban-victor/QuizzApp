package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class Question1Activity extends AppCompatActivity {
    private RadioGroup radioGroupAnswers;
    private Button nextButton;
    private String correctAnswer = "Bucuresti";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        radioGroupAnswers = findViewById(R.id.radioGroupAnswers);
        nextButton = findViewById(R.id.buttonNext);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radioGroupAnswers.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String userAnswer = selectedRadioButton.getText().toString();
                    boolean isCorrect = userAnswer.equals(correctAnswer);

                    Intent intent = new Intent(Question1Activity.this, Question2Activity.class);
                    intent.putExtra("correct_count", isCorrect ? 1 : 0);
                    startActivity(intent);
                }
            }
        });
    }
}
