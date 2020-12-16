package com.nada.technical_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nada.technical_challenge.anagrams.AnagramsActivity;
import com.nada.technical_challenge.currency_converter.CurrencyConverterActivity;
import com.nada.technical_challenge.fibonacci.FibonacciActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button_1);
        btn2 = (Button) findViewById(R.id.button_2);
        btn3 = (Button) findViewById(R.id.button_3);
        btn4 = (Button) findViewById(R.id.button_4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_1: {
                Intent intent = new Intent(getApplicationContext(), AnagramsActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.button_2: {
                Intent intent = new Intent(getApplicationContext(), FibonacciActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.button_3: {
                Intent intent = new Intent(getApplicationContext(), CurrencyConverterActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.button_4: {
                Intent intent = new Intent(getApplicationContext(), ArithmeticException.class);
                startActivity(intent);
                break;
            }

            default:
                break;

        }
    }
}
