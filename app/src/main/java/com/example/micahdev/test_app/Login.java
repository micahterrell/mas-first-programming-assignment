package com.example.micahdev.test_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        //Setup submit button listener
        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ((TextView) findViewById(R.id.emailInput)).getText().toString();
                String password = ((TextView) findViewById(R.id.passwordInput)).getText().toString();
                signIn(view, email, password);
            }
        });
    }

    private void signIn(final View v, String email, String password) {
        if(email.length() == 0) {
            Intent intent = new Intent(v.getContext(), UserMain.class);
            startActivity(intent);
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //TODO Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();

                            Log.d("LOGIN", "Login Successful");

                            Intent intent = new Intent(v.getContext(), UserMain.class);
                            startActivity(intent);
                            //updateUI(user);

                        } else {
                            //TODO If sign in fails, display a message to the user.


                            Log.d("LOGIN", "Login Failed");
                            //updateUI(null);
                        }

                        // ...

                    }
                });
    }
}
