package com.example.logicgupta.lecturenotes.civil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;

import com.example.logicgupta.lecturenotes.R;

public class Civil_Sem_Activity extends AppCompatActivity {
    TabHost tabHost;
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
        setContentView(R.layout.activity_civil__sem_);
        bundle=getIntent().getExtras();
        branch=bundle.getString("civil");
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
                Intent intent=new Intent(Civil_Sem_Activity.this, Sem1_Civil.class);
                intent.putExtra("branch","civil");
                intent.putExtra("semester","SEM1");
                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Civil_Sem_Activity.this, Sem2_Civil.class);
                intent.putExtra("branch","civil");
                intent.putExtra("semester","SEM2");
                startActivity(intent);
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Civil_Sem_Activity.this, Sem3_Civil.class);
                intent.putExtra("branch","civil");
                intent.putExtra("semester","SEM3");
                startActivity(intent);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Civil_Sem_Activity.this, Sem4_Civil.class);
                intent.putExtra("branch","civil");
                intent.putExtra("semester","SEM4");
                startActivity(intent);


            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Civil_Sem_Activity.this, Sem5_Civil.class);
                intent.putExtra("branch","civil");
                intent.putExtra("semester","SEM5");
                startActivity(intent);

            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Civil_Sem_Activity.this, Sem6_Civil.class);
                intent.putExtra("branch","civil");
                intent.putExtra("semester","SEM6");
                startActivity(intent);

            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Civil_Sem_Activity.this, Sem7_Civil.class);
                intent.putExtra("branch","civil");
                intent.putExtra("semester","SEM7");
                startActivity(intent);

            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Civil_Sem_Activity.this, Sem8_Civil.class);
                intent.putExtra("branch","civil");
                intent.putExtra("semester","SEM8");
                startActivity(intent);

            }
        });


    }
}


