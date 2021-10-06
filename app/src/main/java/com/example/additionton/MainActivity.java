package com.example.additionton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.additionton.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*
        String start = binding.startVal.getText().toString();
        String end = binding.endVal.getText().toString(); */

        binding.calcButton.setOnClickListener(v -> calculate());
    }

    protected void calculate() {
        String val1 = binding.startVal.getText().toString();
        String val2 = binding.endVal.getText().toString();

        if (val1.isEmpty() || val2.isEmpty()) {
            Toast.makeText(this, "숫자를 입력해주세요", Toast.LENGTH_LONG).show();
            return;
        }


        int num1 = Integer.parseInt(val1);
        int num2 = Integer.parseInt(val2);

        if (num1 > num2) {
            Toast.makeText(this, "시작 값은 종료 값보다 작거나 같아야 됩니다.", Toast.LENGTH_LONG).show();
            return;
        }


        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            sum += i;
        }

        binding.text3.setText(String.format("%d부터 %d의 값은:", num1, num2));
        binding.result.setText(Integer.toString(sum));
    }
}