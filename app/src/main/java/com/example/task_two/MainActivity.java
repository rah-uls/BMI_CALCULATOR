package com.example.task_two;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button;
        EditText name,email,dob,otp;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button=findViewById(R.id.next);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        dob=findViewById(R.id.dop);
        otp=findViewById(R.id.otp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm=name.getText().toString();
                String eml=email.getText().toString();
                String dte=dob.getText().toString();
                String ottp=otp.getText().toString();
                if (nm.equals("")){
                    name.setError("please enter your name");
                    name.requestFocus();
                    return;
                }
                if (eml.equals("")){
                    email.setError("please enter your email");
                    email.requestFocus();
                    return;
                }
                if (ottp.equals("")){
                    otp.setError("please enter your name");
                    otp.requestFocus();
                    return;
                }
                if (dte.equals("")){
                    dob.setError("please enter your dob");
                    dob.requestFocus();
                    return;
                }
                Intent intent=new Intent(MainActivity.this, next_activity.class);
                startActivity(intent);
            }
        });
    }
}