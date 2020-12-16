package com.nada.technical_challenge.anagrams;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nada.technical_challenge.R;

import java.util.Arrays;

public class AnagramsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGO;
    private EditText str1, str2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagrams);

        btnGO = (Button) findViewById(R.id.button_go);
        str1 = (EditText) findViewById(R.id.editText_1);
        str2 = (EditText) findViewById(R.id.editText_2);
        tv = (TextView) findViewById(R.id.textView_result);

        btnGO.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_go: {

                String value1 = str1.getText().toString() ;
                String value2 = str2.getText().toString();

                if(value1.equals("") || value2.equals("")) {
                    Toast.makeText(getApplicationContext(), "plz enter strings!", Toast.LENGTH_LONG).show();

                } else {
                    anagrams();
                }

                break;
            }

            default:
                break;

        }

    }

    public void anagrams() {

        final String v1 = str1.getText().toString().trim();
        final String v2 = str2.getText().toString().trim();

        String s1 = v1.replaceAll("\\s", "");
        String s2 = v2.replaceAll("\\s", "");

        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }

        if (status) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
            tv.setText("are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
            tv.setText("not anagrams");
        }

    }

}
