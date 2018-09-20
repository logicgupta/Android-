package com.example.logicgupta.lecturenotes.computer_science;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.logicgupta.lecturenotes.R;

public class Sem2_computer extends AppCompatActivity {
    ListView listView1;
    String branch;
    String semester;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem2_computer);
        bundle=getIntent().getExtras();
        branch=bundle.getString("branch");
        semester=bundle.getString("semester");
        listView1=findViewById(R.id.listView1);
        final String sem1[]=getResources().getStringArray(R.array.computer_sem2);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sem1);
        listView1.setAdapter(arrayAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String subject=sem1[position];
                if (position == 0) {
                    Toast.makeText(Sem2_computer.this, ""+subject, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Sem2_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                } else if (position == 1) {
                    Toast.makeText(Sem2_computer.this, ""+subject, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Sem2_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Toast.makeText(Sem2_computer.this, ""+subject, Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(Sem2_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Toast.makeText(Sem2_computer.this,""+subject, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Sem2_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(Sem2_computer.this, " Communication English ", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Sem2_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
            }
        });
    }
}
