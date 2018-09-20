package com.example.logicgupta.lecturenotes;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logicgupta.lecturenotes.chemical.Chemical_Sem_Activity;
import com.example.logicgupta.lecturenotes.civil.Civil_Sem_Activity;
import com.example.logicgupta.lecturenotes.electrical.Electrical_Sem_Activity;
import com.example.logicgupta.lecturenotes.mechanical.Mechanical_Sem_Activity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class List_Branch extends AppCompatActivity {
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    ChildEventListener mChildEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__branch);



        imageView1=findViewById(R.id.imageComputer);
        imageView2=findViewById(R.id.imagemech);
        imageView3=findViewById(R.id.imageelec);
        imageView4=findViewById(R.id.imagecivil);
        imageView5=findViewById(R.id.imageche);
        imageView6=findViewById(R.id.imagedoctor);



                        // Computer Science
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(List_Branch.this,Computer_Sem_Activity.class);
                intent.putExtra("branch","computer");
                startActivity(intent);

            }
        });

                    // Mec
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(List_Branch.this, Mechanical_Sem_Activity.class);
                intent.putExtra("branch","mechanical");
                startActivity(intent);

            }
        });

                    // Elec
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(List_Branch.this, Electrical_Sem_Activity.class);
                intent.putExtra("branch","electrical");
                startActivity(intent);

            }
        });
            // Civil
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(List_Branch.this, Civil_Sem_Activity.class);
                intent.putExtra("branch","civil");
                startActivity(intent);


            }
        });

                //Chemical
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(List_Branch.this, Chemical_Sem_Activity.class);
                intent.putExtra("branch","chemical");
                startActivity(intent);

            }
        });
        //Chemical
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(List_Branch.this, "Comming Soon....", Toast.LENGTH_LONG).show();;

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile_menu:
                UserInfo_Menu();

                break;
            case R.id.logout_menu:
                user_SignOut();
                break;
                default:
                    break;
        }
        return super.onOptionsItemSelected(item);
    }

    void UserInfo_Menu(){
        final Dialog dialog=new Dialog(List_Branch.this);
        dialog.setContentView(R.layout.profile_info);
        Button btn=dialog.findViewById(R.id.ok_btn);
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("Profile");
        mChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                UserDetails userDetails=dataSnapshot.getValue(UserDetails.class);
                TextView textView1=dialog.findViewById(R.id.nameText);
                textView1.setText(userDetails.getName());

                TextView textView2=dialog.findViewById(R.id.emailText);
                textView2.setText(userDetails.getEmail());

                TextView textView3=dialog.findViewById(R.id.collgeText);
                textView3.setText(userDetails.getCollege());

                TextView textView4=dialog.findViewById(R.id.branchText);
                textView4.setText(userDetails.getBranch());

                TextView textView5=dialog.findViewById(R.id.phoneText);
                textView5.setText(userDetails.getPhone());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildEventListener);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
     // User sign out from Firebase ...
    void user_SignOut(){
        FirebaseAuth mFirebaseAuth;
        mFirebaseAuth= FirebaseAuth.getInstance();
        mFirebaseAuth.signOut();
        startActivity(new Intent(this,Login_Activity.class));
        finish();
    }
}
