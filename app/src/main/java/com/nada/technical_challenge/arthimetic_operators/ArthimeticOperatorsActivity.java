package com.nada.technical_challenge.arthimetic_operators;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nada.technical_challenge.R;
import com.nada.technical_challenge.anagrams.AnagramsActivity;
import com.nada.technical_challenge.currency_converter.CurrencyConverterActivity;
import com.nada.technical_challenge.fibonacci.FibonacciActivity;

public class ArthimeticOperatorsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private EditText v1, v2, v3, v4;
    private TextView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arthimetic_operators);

        btn = (Button) findViewById(R.id.button_go);
        v1 = (EditText) findViewById(R.id.editText_1);
        v2 = (EditText) findViewById(R.id.editText_2);
        v3 = (EditText) findViewById(R.id.editText_3);
        v4 = (EditText) findViewById(R.id.editText_4);
        r = (TextView) findViewById(R.id.textView_result);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_1: {
                String value1 = v1.getText().toString() ;
                String value2 = v2.getText().toString() ;
                String value3 = v3.getText().toString() ;
                String value4 = v4.getText().toString() ;

                if(value1.equals("") || value2.equals("") || value3.equals("") || value4.equals("")) {
                    Toast.makeText(getApplicationContext(), "plz enter number!", Toast.LENGTH_LONG).show();

                } else {
                    double number1 = Double.parseDouble(v1.getText().toString());
                    double number2 = Double.parseDouble(v2.getText().toString());
                    double number3 = Double.parseDouble(v3.getText().toString());
                    double number4 = Double.parseDouble(v4.getText().toString());

                    r.setText("" + result(number1, number2, number3, number4));
                }
                break;
            }

            default:
                break;

        }
    }

    public double result(double a, double b, double c, double d) {

        double r = a * (b + c - d);

        return r;
    }

}
