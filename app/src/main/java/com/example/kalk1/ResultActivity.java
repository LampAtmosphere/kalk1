package com.example.kalk1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.result_text_view);

        int firstNumber = getIntent().getIntExtra("firstNumber", 0);
        int secondNumber = getIntent().getIntExtra("secondNumber", 0);
        int sum = firstNumber + secondNumber;

        String expression = String.format("%d + %d = %d", firstNumber, secondNumber, sum);
        resultTextView.setText(expression);
    }
}
