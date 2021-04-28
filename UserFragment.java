package com.omerkagandanaci.projecttrial.View.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.omerkagandanaci.projecttrial.R;
import com.omerkagandanaci.projecttrial.View.ForgotPasswordActivity;

public class UserFragment extends Fragment {

    TextView forgotPassword;
    TextView newUser;
    Button buttonLogin;
    FirebaseAuth auth;
    String email;
    String password;
    FirebaseUser user;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        forgotPassword = view.findViewById(R.id.textViewForgot);
        newUser = view.findViewById(R.id.textViewNewUser);
        buttonLogin = view.findViewById(R.id.buttonLogin);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Intent i = new Intent(getActivity(), UserMainActivity.class);
            startActivity(i);
            getActivity().finish();
        }

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity().getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent1);
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity().getApplicationContext(), SignUpActivity.class);
                startActivity(intent2);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                auth = FirebaseAuth.getInstance();
                email = ((EditText) view.findViewById(R.id.editTextText1)).getText().toString();
                password = ((EditText) view.findViewById(R.id.editTextText2)).getText().toString();

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {

                    @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Intent i = new Intent(UserFragment.this.getActivity().getApplicationContext(), UserMainActivity.class);
                           startActivity(i);
                       }
                       else {
                           Toast.makeText(getActivity(), "Wrong email or password!", Toast.LENGTH_LONG).show();
                       }
                   }
               });
            }

        });
        return view;
    }
}
