package com.omerkagandanaci.projecttrial.View.User;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.omerkagandanaci.projecttrial.R;

import java.util.HashMap;
import java.util.Map;


public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth auth;
    CheckBox checkBox;
    EditText editText;
    String email;
    String password;
    String name;
    String surname;
    String phoneNo;
    String tcId;
    String birthDate;
    Boolean isTurkish;
    FirebaseFirestore db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        editText = findViewById(R.id.editTextPassBirthDate);
        checkBox = findViewById(R.id.checkBoxTC);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    editText.setHint("Passport No");
                }
                else{
                    editText.setHint("TC ID No");
                }
            }

        });
    }

    public  void signUp(View v){

            email = ((EditText) findViewById(R.id.editTextPassName)).getText().toString();
            password = ((EditText) findViewById(R.id.editTextPassSurname)).getText().toString();
            name = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
            surname = ((EditText) findViewById(R.id.editTextTextPersonSurname)).getText().toString();
            phoneNo = ((EditText) findViewById(R.id.editTextPassTCId)).getText().toString();
            tcId = ((EditText) findViewById(R.id.editTextPassBirthDate)).getText().toString();
            birthDate = ((EditText) findViewById(R.id.editTextTextBirthDate)).getText().toString();
            if (((CheckBox) findViewById(R.id.checkBoxTC)).isChecked()) {
                isTurkish = true;

            } else {
                isTurkish = false;
            }

            db = FirebaseFirestore.getInstance();
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>(){

                @Override
                public void onComplete(Task<AuthResult> task){
                    if(task.isSuccessful()){
                        FirebaseUser user = auth.getCurrentUser();

                        Map<String, Object> localUser = new HashMap<>();
                        localUser.put("email", email);
                        localUser.put("password", password);
                        localUser.put("name", name);
                        localUser.put("surname", surname);
                        localUser.put("phoneNo", phoneNo);
                        localUser.put("isTurkish?", !isTurkish);
                        localUser.put("TC Id", tcId);
                        localUser.put("birthDate", birthDate);


                        db.collection("users")
                                .add(localUser)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w("TAG", "Error adding document", e);
                                    }
                                });


                        Intent i = new Intent(SignUpActivity.this, UserMainActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(SignUpActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
                    }
                }
            });

    }
}
