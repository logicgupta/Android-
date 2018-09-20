package com.example.logicgupta.lecturenotes.computer_science;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logicgupta.lecturenotes.R;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {

    RecyclerView recyclerView;
    Context context;
    ArrayList<String> items=new ArrayList<String>();
    ArrayList<String> url=new ArrayList<String>();

    public void update(String filename,String urls){
        items.add(filename);
        url.add(urls);
        notifyDataSetChanged();
    }

    public MyAdapter1(RecyclerView recyclerView, Context context, ArrayList<String> items, ArrayList<String> url) {

        this.recyclerView = recyclerView;
        this.context = context;
        this.items = items;
        this.url = url;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.card_view1_sem1_file,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(items.get(position));
        if(items.get(position)==null){
            Toast.makeText(context, "No Content Available", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        ProgressBar progressBar;
        public ViewHolder(final View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.filename1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=recyclerView.getChildLayoutPosition(itemView);
                    Intent intent=new Intent();
                    intent.setType(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url.get(position)));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Intent chooserIntent = Intent.createChooser(intent, "Open With");
                    chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(chooserIntent);

                }
            });
        }
    }
}
