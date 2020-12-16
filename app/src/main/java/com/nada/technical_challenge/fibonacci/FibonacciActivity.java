package com.nada.technical_challenge.fibonacci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nada.technical_challenge.R;

public class FibonacciActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGO1, btnGO2;
    private EditText n1, n2;
    private TextView r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        btnGO1 = (Button) findViewById(R.id.button_go1);
        btnGO2 = (Button) findViewById(R.id.button_go2);
        n1 = (EditText) findViewById(R.id.editText_1);
        n2 = (EditText) findViewById(R.id.editText_2);
        r1 = (TextView) findViewById(R.id.textView_result1);
        r2 = (TextView) findViewById(R.id.textView_result2);

        btnGO1.setOnClickListener(this);
        btnGO2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_go1: {

                String value1 = n1.getText().toString() ;

                if(value1.equals("")) {
                    Toast.makeText(getApplicationContext(), "plz enter number!", Toast.LENGTH_LONG).show();

                } else {
                    int number = Integer.parseInt(n1.getText().toString());
                    r1.setText("" + fibonacci_recursion(number));
                }

                break;
            }

            case R.id.button_go2: {

                String value2 = n2.getText().toString() ;

                if(value2.equals("")) {
                    Toast.makeText(getApplicationContext(), "plz enter number!", Toast.LENGTH_LONG).show();

                } else {
                    int number = Integer.parseInt(n2.getText().toString());
                    r2.setText("" + fibonacci_dynamic(number));
                }

                break;
            }

            default: {
                break;
            }

        }

    }

    public int fibonacci_recursion(int n) {

        if (n <= 1) {
            return n;
        }

        return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);

    }

    public int fibonacci_dynamic(int n) {

        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 1];
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;

        if (n > 0) {
            f[1] = 1;
            for (i = 2; i <= n; i++) {
                /* Add the previous 2 numbers in the series
             and store it */
                f[i] = f[i - 1] + f[i - 2];
            }
        }

        return f[n];

    }

}
