package com.example.logicgupta.lecturenotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class Login_Activity extends AppCompatActivity {

    /*
            created by Logic Gupta

     */
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mFirebaseAuthStateListener;
    private static final int RC_SIGN_IN = 123;
    private EditText username,password;
    EditText e1;
    private TextView forgot_password;
    private Button login_btn,register_btn;
    private static final String TAG="Login_Activity";
    ProgressDialog pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        mFirebaseAuth = FirebaseAuth.getInstance();
        forgot_password=findViewById(R.id.forgot_password);
        username=findViewById(R.id.emailEditText);
        password=findViewById(R.id.passwordEditText);
        login_btn=findViewById(R.id.login_btn);
        register_btn=findViewById(R.id.register_btn);

        /*
                forgot password
         */
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setForgot_password();
            }
        });


            /*
                    Login Button .......
             */
        login_btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String username1=username.getText().toString();
                String password1=password.getText().toString();
                if(username1.equals("") && password1.equals("")){
                    AlertDialog.Builder al;
                    al=new AlertDialog.Builder(Login_Activity.this);
                    al.setTitle(" ");
                    al.setIcon(R.drawable.error_logo);
                    al.setCancelable(false);
                    al.setMessage("Please Enter Username and Password !");
                    al.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    al.show();
                }
                else{
                    pb=new ProgressDialog(Login_Activity.this);
                    pb.setMessage("loading ...");
                    pb.setCancelable(false);
                    pb.show();
                    CreateAccount(username1,password1);
                }
                }


        });

        // responds to changes in the user's sign-in state
        mFirebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());

                    // Authenticated successfully with authData
                    Intent intent = new Intent(Login_Activity.this,List_Branch.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                } else {
                    // User is signed out

                    Log.d("TAG", "onAuthStateChanged:signed_out");
                }
            }
        };


            /*
                    Register the new User ...
         */
            register_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Login_Activity.this,Register_New_User.class));


                }
            });


    }

    private void CreateAccount(String username1, String password1){
        mFirebaseAuth.signInWithEmailAndPassword(username1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login_Activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
                    // Update the UI for the user sign in and sign out

    private void updateUI(FirebaseUser user){
        if (user!=null){
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
            pb.dismiss();
            startActivity(new Intent(Login_Activity.this,User_Details.class));
            finish();
        }
        else {
            pb.dismiss();
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();

        }
    }
     /*
                Forgot password

         */
     void setForgot_password(){

                 setContentView(R.layout.forgot_password_layout);
                 e1=findViewById(R.id.emailEdit);
                 Button bt1=findViewById(R.id.submit_btn);
                 bt1.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         String emailId=e1.getText().toString();

                         if(TextUtils.isEmpty(emailId)){
                             Toast.makeText(Login_Activity.this,"Enter Email Address !",Toast.LENGTH_SHORT).show();
                         }
                         else {
                             mFirebaseAuth.sendPasswordResetEmail(emailId);
                             startActivity(new Intent(Login_Activity.this,Login_Activity.class));
                             Toast.makeText(Login_Activity.this, "Please CheckOut your EmailId ", Toast.LENGTH_LONG).show();
                             finish();
                         }

                     }
                 });


     }

    @Override
    protected void onResume() {

        mFirebaseAuth.addAuthStateListener(mFirebaseAuthStateListener);
        super.onResume();
    }

    @Override
    protected void onPause() {
        mFirebaseAuth.removeAuthStateListener(mFirebaseAuthStateListener);
        super.onPause();
    }
}

