package com.example.logicgupta.lecturenotes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register_New_User extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    Button signUp_button;
    EditText nameEditText,emailEditText,passwordeditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__new__user);
        nameEditText=findViewById(R.id.nameEditText);
        emailEditText=findViewById(R.id.emailEditText);
        passwordeditText=findViewById(R.id.passwordEditText);

        signUp_button=findViewById(R.id.signUp_btn);
         signUp_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String name,email,password;
                 name=nameEditText.getText().toString();
                 email=emailEditText.getText().toString();
                 password=passwordeditText.getText().toString();
                 if(name.equals("") && email.equals("") && password.equals("")){
                     AlertDialog.Builder al;
                     al=new AlertDialog.Builder(Register_New_User.this);
                     al.setTitle("Error");
                     al.setIcon(R.drawable.error_logo);
                     al.setCancelable(false);
                     al.setMessage("Please Fill all Fields !");
                     al.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     });
                     al.show();

                 }
                 else if(name.equals("")){
                     nameEditText.setError("Enter Name!");

                 }
                 else if(email.equals("")){
                     emailEditText.setError("Enter Email !");

                 }
                 else if ((password.equals(""))){
                     passwordeditText.setError("Enter Password !");

                 }
                 else{
                     Log.d("ghj",email+""+password);
                     mFirebaseAuth=FirebaseAuth.getInstance();
                     mFirebaseAuth.createUserWithEmailAndPassword(email,password)
                             .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                 @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                     if(!task.isSuccessful()){

                                         Toast.makeText(Register_New_User.this, "Please Enter Valid Credentials", Toast.LENGTH_SHORT).show();

                                     }
                                     else{
                                         FirebaseUser user=mFirebaseAuth.getCurrentUser();
                                         updateUI(user);

                                     }

                                 }
                             });

                 }

             }
         });

    }

    void updateUI(FirebaseUser user){
        if(user!=null){
            startActivity(new Intent(Register_New_User.this,User_Details.class));
            finish();
        }
        else{
            Toast.makeText(this, "Please Try Again !", Toast.LENGTH_SHORT).show();
        }

    }
}
