package com.example.ezvill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private EditText msignupemail,msignuppassword;
    private RelativeLayout msignup;
    private TextView mgotologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        msignupemail=findViewById(R.id.signupemail);
        msignuppassword=findViewById(R.id.signuppassword);
        msignup=findViewById(R.id.signup);
        mgotologin=findViewById(R.id.gotologin);

        mgotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);
            }
        });

        msignup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String mail=msignupemail.getText().toString().trim();
            String password=msignuppassword.getText().toString().trim();
            if (mail.isEmpty() || password.isEmpty()){
                Toast.makeText(getApplicationContext(), "need all of it", Toast.LENGTH_SHORT).show();
            }
            else if(password.length()<7){
                Toast.makeText(getApplicationContext(), "password should greater than 7", Toast.LENGTH_SHORT).show();
            }
            else{
                //////register
            }

            }
        });
    }
}