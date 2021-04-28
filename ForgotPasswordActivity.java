package com.omerkagandanaci.projecttrial.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.omerkagandanaci.projecttrial.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                auth = FirebaseAuth.getInstance();
//        auth.sendPasswordResetEmail(((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString());//.addOnCompleteListener(
//        ForgotPasswordActivity.this,new OnCompleteListener<AuthResult>(){
//
//            @Override
//            public void onComplete(Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(ForgotPasswordActivity.this, "Something went wrong \n Try again", Toast.LENGTH_LONG).show();
//                }
//                else
//                    Toast.makeText(ForgotPasswordActivity.this, "Something went wrong \n Try again", Toast.LENGTH_LONG).show();
//            }
//        });
            }
        });
    }
}    
    

    
