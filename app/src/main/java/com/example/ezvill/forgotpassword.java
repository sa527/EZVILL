package com.example.ezvill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class forgotpassword extends AppCompatActivity {
    private EditText mforgotpassword;
    private Button mpasswordrecoverybutton;
    private TextView mgobacktologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        getSupportActionBar().hide();

        mforgotpassword=findViewById(R.id.forgotpassword);
        mpasswordrecoverybutton=findViewById(R.id.passwordcoverbutton);
        mgobacktologin = findViewById(R.id.gobacktologin);
        mgobacktologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(forgotpassword.this,MainActivity.class);
                startActivity(intent);

            }
        });
        mpasswordrecoverybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail =mforgotpassword.getText().toString().trim();
                if (mail.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //we have to sendpassword receiver email
                }
            }
        });
    }

}