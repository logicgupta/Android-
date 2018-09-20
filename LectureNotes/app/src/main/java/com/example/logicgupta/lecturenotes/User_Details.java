package com.example.logicgupta.lecturenotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User_Details extends Activity {


    EditText nameEditText,emailEditText,collegeEditText,branchEditText,phoneEditText;
    Button btn;
    AlertDialog.Builder ab;
    FirebaseDatabase mfirebaseDatabase;
    DatabaseReference mDataBaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__details);
        nameEditText=findViewById(R.id.nameField);
        emailEditText=findViewById(R.id.emailField);
        phoneEditText=findViewById(R.id.phoneField);
        collegeEditText=findViewById(R.id.collgeField);
        branchEditText=findViewById(R.id.branchField);
        phoneEditText=findViewById(R.id.phoneField);
        btn=findViewById(R.id.submit_btn);


            // FirebaseDataBase Initilize ......

         mfirebaseDatabase=FirebaseDatabase.getInstance();
         mDataBaseReference=mfirebaseDatabase.getReference("Profile");

            // Submit the data to Firebase

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEditText.getText().toString();
                String email=emailEditText.getText().toString();
                String phone=phoneEditText.getText().toString();
                String college=collegeEditText.getText().toString();
                String branch=branchEditText.getText().toString();
                if(name.equals("")&& email.equals("") && phone.equals("") && college.equals("") && branch.equals("")){
                    ab=new AlertDialog.Builder(User_Details.this);
                    ab.setTitle("Error");
                    ab.setIcon(R.drawable.error_logo);
                    ab.setMessage("Please Fill the Details !");
                    ab.setCancelable(false);
                    ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ab.show();
                }
                else {
                    if(name.equals("")){
                        nameEditText.setText("Please Enter Name!");

                    }
                    else if (email.equals("")){
                        emailEditText.setError("Please Enter Email!");

                    }
                    else if(phone.equals("")){
                        phoneEditText.setError("Please Enter PhoneNumber !");

                    }else if(college.equals("")){
                        collegeEditText.setError("Please Enter College Name");

                    }else if (branch.equals("")){
                        branchEditText.setError("Please Enter Branch ");

                    }else {
                                UserDetails userDetails=new UserDetails(name,email,phone,college,branch);
                               mDataBaseReference.push().setValue(userDetails);
                                startActivity(new Intent(User_Details.this,List_Branch.class));
                                finish();



                    }
                }
            }
        });

    }
}
