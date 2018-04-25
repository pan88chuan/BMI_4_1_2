package com.demo.android.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Bmi extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("0.00");

        EditText field_height = findViewById(R.id.field_height);
        EditText field_weight = findViewById(R.id.field_weight);

        double height = Double.parseDouble(field_height.getText().toString()) / 100;
        double weight = Double.parseDouble(field_weight.getText().toString());
        double BMI = weight / (height * height);

        TextView result = findViewById(R.id.result);
        result.setText("你的BMI值 = " + df.format(BMI));
        TextView suggest = findViewById(R.id.suggest);

        if (BMI > 25)
            suggest.setText(R.string.advice_heavy);
        else if (BMI < 20)
            suggest.setText(R.string.advice_light);
        else
            suggest.setText(R.string.advice_average);
    }
}


