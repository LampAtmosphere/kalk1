package com.example.kalk1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberEditText;
    private EditText secondNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = findViewById(R.id.first_number_edit_text);
        secondNumberEditText = findViewById(R.id.second_number_edit_text);

        if (savedInstanceState != null) {
            String firstNumber = savedInstanceState.getString("firstNumber");
            String secondNumber = savedInstanceState.getString("secondNumber");

            firstNumberEditText.setText(firstNumber);
            secondNumberEditText.setText(secondNumber);
        }
    }

    public void onAddButtonClick(View view) {
        try {
            int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
            int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("firstNumber", firstNumber);
            intent.putExtra("secondNumber", secondNumber);
            startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Введите целое число", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("firstNumber", firstNumberEditText.getText().toString());
        outState.putString("secondNumber", secondNumberEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String firstNumber = savedInstanceState.getString("firstNumber");
        String secondNumber = savedInstanceState.getString("secondNumber");

        firstNumberEditText.setText(firstNumber);
        secondNumberEditText.setText(secondNumber);
    }
}
