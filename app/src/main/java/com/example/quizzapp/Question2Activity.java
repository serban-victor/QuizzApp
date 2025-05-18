package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class Question2Activity extends AppCompatActivity {
    private RadioGroup radioGroupAnswers;
    private Button nextButton;
    private String correctAnswer = "2505";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        radioGroupAnswers = findViewById(R.id.radioGroupAnswers);
        nextButton = findViewById(R.id.buttonNext);

        // Get correct count from previous question
        final int correctCount = getIntent().getIntExtra("correct_count", 0);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radioGroupAnswers.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String userAnswer = selectedRadioButton.getText().toString();
                    boolean isCorrect = userAnswer.equals(correctAnswer);

                    int newCorrectCount = correctCount + (isCorrect ? 1 : 0);

                    Intent intent = new Intent(Question2Activity.this, Question3Activity.class);
                    intent.putExtra("correct_count", newCorrectCount);
                    startActivity(intent);
                }
            }
        });
    }
}
