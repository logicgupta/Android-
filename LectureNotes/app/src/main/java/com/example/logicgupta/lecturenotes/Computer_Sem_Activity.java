package com.example.logicgupta.lecturenotes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.logicgupta.lecturenotes.computer_science.Math_sem1_computer;
import com.example.logicgupta.lecturenotes.computer_science.Sem1_computer;
import com.example.logicgupta.lecturenotes.computer_science.Sem2_computer;
import com.example.logicgupta.lecturenotes.computer_science.Sem3_computer;
import com.example.logicgupta.lecturenotes.computer_science.Sem4_computer;
import com.example.logicgupta.lecturenotes.computer_science.Sem5_computer;
import com.example.logicgupta.lecturenotes.computer_science.Sem6_computer;
import com.example.logicgupta.lecturenotes.computer_science.Sem7_computer;
import com.example.logicgupta.lecturenotes.computer_science.Sem8_computer;

public class Computer_Sem_Activity extends AppCompatActivity {
   ImageButton imageButton1;
   ImageButton imageButton2;
   ImageButton imageButton3;
   ImageButton imageButton4;
   ImageButton imageButton5;
   ImageButton imageButton6;
   ImageButton imageButton7;
   ImageButton imageButton8;
   Bundle bundle;
   String branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer__sem_);

        bundle=getIntent().getExtras();
        branch=bundle.getString("computer");
        imageButton1=findViewById(R.id.imagebutton1);
        imageButton2=findViewById(R.id.imagebutton2);
        imageButton3=findViewById(R.id.imagebutton3);
        imageButton4=findViewById(R.id.imagebutton4);
        imageButton5=findViewById(R.id.imagebutton5);
        imageButton6=findViewById(R.id.imagebutton6);
        imageButton7=findViewById(R.id.imagebutton7);
        imageButton8=findViewById(R.id.imagebutton8);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Computer_Sem_Activity.this, Sem1_computer.class);
                intent.putExtra("branch","computer");
                intent.putExtra("semester","SEM1");
                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Computer_Sem_Activity.this, Sem2_computer.class);
                intent.putExtra("branch","computer");
                intent.putExtra("semester","SEM2");
                startActivity(intent);
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Computer_Sem_Activity.this, Sem3_computer.class);
                intent.putExtra("branch","computer");
                intent.putExtra("semester","SEM3");
                startActivity(intent);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Computer_Sem_Activity.this, Sem4_computer.class);
                intent.putExtra("branch","computer");
                intent.putExtra("semester","SEM4");
                startActivity(intent);


            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Computer_Sem_Activity.this, Sem5_computer.class);
                intent.putExtra("branch","computer");
                intent.putExtra("semester","SEM5");
                startActivity(intent);

            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Computer_Sem_Activity.this, Sem6_computer.class);
                intent.putExtra("branch","computer");
                intent.putExtra("semester","SEM6");
                startActivity(intent);

            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Computer_Sem_Activity.this, Sem7_computer.class);
                intent.putExtra("branch","computer");
                intent.putExtra("semester","SEM7");
                startActivity(intent);

            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Computer_Sem_Activity.this, Sem8_computer.class);
                intent.putExtra("branch","computer");
                intent.putExtra("semester","SEM8");
                startActivity(intent);

            }
        });




    }
}
