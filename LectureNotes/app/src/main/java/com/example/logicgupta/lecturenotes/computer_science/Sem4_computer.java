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
import com.example.logicgupta.lecturenotes.chemical.Sem4_Chemical;

public class Sem4_computer extends AppCompatActivity {

    ListView listView1;
    String branch;
    String semester;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem1_computer);
        bundle=getIntent().getExtras();
        branch=bundle.getString("branch");
        semester=bundle.getString("semester");
        listView1=findViewById(R.id.listView1);
        final String sem2[]=getResources().getStringArray(R.array.computer_sem4);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(Sem4_computer.this,android.R.layout.simple_list_item_1,sem2);
        listView1.setAdapter(arrayAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String subject=sem2[position];
                if (position == 0) {
                    Intent intent=new Intent(Sem4_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                } else if (position == 1) {

                    Intent intent=new Intent(Sem4_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent=new Intent(Sem4_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent=new Intent(Sem4_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                }
                else {
                    Intent intent=new Intent(Sem4_computer.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
            }
        });
    }
}
