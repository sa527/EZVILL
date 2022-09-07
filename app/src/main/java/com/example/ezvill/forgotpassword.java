package com.example.ezvill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {
    private EditText mforgotpassword;
    private Button mpasswordrecoverybutton;
    private TextView mgobacktologin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        getSupportActionBar().hide();

        mforgotpassword=findViewById(R.id.forgotpassword);
        mpasswordrecoverybutton=findViewById(R.id.passwordcoverbutton);
        mgobacktologin = findViewById(R.id.gobacktologin);

        firebaseAuth = FirebaseAuth.getInstance();

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
                    firebaseAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Mail Sent, you can recover your password", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(forgotpassword.this,MainActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Email is Wrong or Account not Exist", Toast.LENGTH_SHORT).show();
                        }
                        }
                    });
                }
            }
        });
    }

}