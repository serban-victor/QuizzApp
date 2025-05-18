package com.example.quizzapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView correctAnswersTextView = findViewById(R.id.textViewCorrectAnswers);
        TextView incorrectAnswersTextView = findViewById(R.id.textViewIncorrectAnswers);

        // Get the number of correct and incorrect answers from Intent
        int correctCount = getIntent().getIntExtra("correct_count", 0);
        int incorrectCount = getIntent().getIntExtra("incorrect_count", 0);

        correctAnswersTextView.setText("Răspunsuri Corecte: " + correctCount);
        incorrectAnswersTextView.setText("Răspunsuri Greșite: " + incorrectCount);
    }
}
