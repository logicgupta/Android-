package com.example.logicgupta.lecturenotes.chemical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.logicgupta.lecturenotes.R;
import com.example.logicgupta.lecturenotes.computer_science.Math_sem1_computer;
import com.example.logicgupta.lecturenotes.computer_science.MyRecycler_View;

public class Sem3_Chemical extends AppCompatActivity {
    ListView listView1;
    String branch;
    String semester;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem3__chemical);
        bundle=getIntent().getExtras();
        branch=bundle.getString("branch");
        semester=bundle.getString("semester");
        listView1=findViewById(R.id.listView1);
        String sem1[]=getResources().getStringArray(R.array.chemical_sem3);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sem1);
        listView1.setAdapter(arrayAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Sem3_Chemical.this, " Maths ", Toast.LENGTH_SHORT).show();
                    String subject="MATHS";
                    Intent intent=new Intent(Sem3_Chemical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                } else if (position == 1) {
                    Toast.makeText(Sem3_Chemical.this, " Physics ", Toast.LENGTH_SHORT).show();
                    String subject="Physics";
                    Intent intent=new Intent(Sem3_Chemical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Toast.makeText(Sem3_Chemical.this, " C++ ", Toast.LENGTH_SHORT).show();
                    String subject="C++";
                    Intent intent=new Intent(Sem3_Chemical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Toast.makeText(Sem3_Chemical.this, " Electrical Circuit Analysics ", Toast.LENGTH_SHORT).show();
                    String subject="Electric Circuit";
                    Intent intent=new Intent(Sem3_Chemical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(Sem3_Chemical.this, " Communication English ", Toast.LENGTH_SHORT).show();
                    String subject="Communication English";
                    Intent intent=new Intent(Sem3_Chemical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
            }
        });
    }
}
