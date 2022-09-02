package com.example.ezvill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mloginemail,mloginpassword;
    RelativeLayout mlogin,msignup;
    TextView mgotoforgotpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        mloginemail=findViewById(R.id.loginemail);
        mloginpassword=findViewById(R.id.loginpassword);
        mlogin=findViewById(R.id.login);
        mgotoforgotpassword=findViewById(R.id.gotoforgotpassword);
        msignup=findViewById(R.id.signup);

        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });
//        mgotoforgotpassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,forgotpassword.class));
//            }
//        });
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail= mloginemail.getText().toString().trim();
                String password=mloginpassword.getText().toString().trim();
                if(mail.isEmpty()||password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "All FIeld are Requird", Toast.LENGTH_SHORT).show();
                }
                else{
                    //login this user
                }
            }
        });
    }
}