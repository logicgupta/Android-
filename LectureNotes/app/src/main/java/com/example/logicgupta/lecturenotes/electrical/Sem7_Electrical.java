package com.example.logicgupta.lecturenotes.electrical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.logicgupta.lecturenotes.R;
import com.example.logicgupta.lecturenotes.computer_science.Math_sem1_computer;
import com.example.logicgupta.lecturenotes.computer_science.MyRecycler_View;
import com.example.logicgupta.lecturenotes.computer_science.Sem7_computer;

public class Sem7_Electrical extends AppCompatActivity {
    ListView listView1;
    String branch;
    String semester;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem7__electrical);
        bundle=getIntent().getExtras();
        branch=bundle.getString("branch");
        semester=bundle.getString("semester");
        listView1=findViewById(R.id.listView1);
        final String sem1[]=getResources().getStringArray(R.array.electrical_sem7);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(Sem7_Electrical.this,android.R.layout.simple_list_item_1,sem1);
        listView1.setAdapter(arrayAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String subject=sem1[position];
                if (position == 0) {
                    Intent intent=new Intent(Sem7_Electrical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                } else if (position == 1) {
                    Intent intent=new Intent(Sem7_Electrical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                }
                else if (position == 2) {
                    Intent intent=new Intent(Sem7_Electrical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }
                else if (position == 3) {

                    Intent intent=new Intent(Sem7_Electrical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                }
                else{
                    Intent intent=new Intent(Sem7_Electrical.this,MyRecycler_View.class);
                    intent.putExtra("branch",branch);
                    intent.putExtra("semester",semester);
                    intent.putExtra("subject",subject);
                    startActivity(intent);
                }

            }
        });
    }
}
