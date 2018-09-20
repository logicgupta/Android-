package com.example.logicgupta.lecturenotes.computer_science;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.logicgupta.lecturenotes.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyRecycler_View extends AppCompatActivity {
    RecyclerView recyclerView;
    Bundle bundle;
    String semester;
    String subject;
    String branch;
    MyAdapter1 myAdapter1;
    ProgressDialog dialog;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_recycler_view1);
        recyclerView=findViewById(R.id.recyclerView1);
        data();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter1=new MyAdapter1(recyclerView,getApplicationContext(),new ArrayList<String>(),new ArrayList<String>());
        recyclerView.setAdapter(myAdapter1);
        if (myAdapter1.getItemCount()==0){
            Log.e(" My Recycler View","Null ");

        }
    }
    void data(){
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading Data...");
        dialog.show();
        bundle=getIntent().getExtras();
        semester=bundle.getString("semester");
        subject=bundle.getString("subject");
        branch=bundle.getString("branch");
        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Files\\"+branch+"\\"+semester+"\\"+subject);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    String filename=dataSnapshot.getKey();
                    String url=dataSnapshot.getValue(String.class);

                    Log.e(" My Recycler View","dataSnapshot ");
                    ((MyAdapter1)recyclerView.getAdapter()).update(filename,url);
                    dialog.dismiss();



            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                dialog.dismiss();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                dialog.dismiss();

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                dialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                dialog.dismiss();

            }
        });

    }

}
