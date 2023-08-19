package com.zelda.inchesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private EditText metersEditText;
    private TextWatcher inchesEditTextWatcher;
    private TextWatcher metersEditTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();


        inchesEditTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                metersEditText.removeTextChangedListener(metersEditTextWatcher);
                InchesToMeters();
                metersEditText.addTextChangedListener(metersEditTextWatcher);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        inchesEditText.addTextChangedListener(inchesEditTextWatcher);


        metersEditTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                inchesEditText.removeTextChangedListener(inchesEditTextWatcher);
                MetersToInches();
                inchesEditText.addTextChangedListener(inchesEditTextWatcher);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        metersEditText.addTextChangedListener(metersEditTextWatcher);

    }

    private void MetersToInches() {
        String metersText = metersEditText.getText().toString();
        double meters;
        try {
            meters = Double.parseDouble(metersText);
        } catch (Exception e) {
            inchesEditText.setText("");
            return;
        }
        int inches = (int) (meters / 0.0254);
        String inchesText = String.valueOf(inches);
        inchesEditText.setText(inchesText);
    }

    private void InchesToMeters() {
        String inchesText = inchesEditText.getText().toString();
        int inches;
        try {
            inches = Integer.parseInt(inchesText);
        } catch (Exception e) {
            metersEditText.setText("");
            return;
        }
        double meters = inches * 0.0254;
        String metersText = String.valueOf(meters);
        metersEditText.setText(metersText);
    }


    private void findView() {
        inchesEditText = findViewById(R.id.inches_edit_text);
        metersEditText = findViewById(R.id.meters_edit_text);
        // Question: why these input doesn't need listener?
    }
}