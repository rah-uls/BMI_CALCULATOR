package com.example.task_two;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class next_activity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next);
        EditText hight,hight1, weight;
        TextView answer,seggest;
        Button button,button1;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        hight=findViewById(R.id.hight);
        hight1=findViewById(R.id.hight1);
        weight=findViewById(R.id.weight);
        button=findViewById(R.id.calculate);
        answer=findViewById(R.id.answer);
        seggest=findViewById(R.id.suggest);
        button1=findViewById(R.id.calculate1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wg=weight.getText().toString();
                String ht=hight.getText().toString();
                String ht1=hight1.getText().toString();
                if (ht.equals("")){
                    hight.setError("please enter your hight");
                    hight.requestFocus();
                    return;
                }
                if(ht1.equals("")) {
                    hight1.setError("please enter your hight");
                    hight1.requestFocus();
                    return;
                }
                if(wg.equals("")){
                    weight.setError("please enter your weight");
                    weight.requestFocus();
                    return;
                }
                int we= Integer.parseInt( weight.getText().toString());
                int hi= Integer.parseInt( hight.getText().toString());
                int hinch= Integer.parseInt( hight1.getText().toString());
                int totl_ich=hi*12+hinch;
                double ttlcm=totl_ich*2.53;
                double tolmtr=ttlcm/100;
                double bmi =we/(tolmtr*tolmtr);
                answer.setText(String.valueOf(bmi));
                if(bmi>30 && bmi < 60){
                    seggest.setText("over weight");
                }
                else if(bmi > 60){
                    seggest.setText("poor weight");
                }
                else if (bmi<30){
                    seggest.setText("healthy");
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight.setText("");
                hight.setText("");
                hight1.setText("");
                answer.setText("");
                seggest.setText("");
            }
        });
    }
}