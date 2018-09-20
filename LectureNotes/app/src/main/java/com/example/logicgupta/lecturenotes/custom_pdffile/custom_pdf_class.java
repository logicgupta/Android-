package com.example.logicgupta.lecturenotes.custom_pdffile;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.logicgupta.lecturenotes.R;
import com.github.barteksc.pdfviewer.PDFView;

public class custom_pdf_class extends ArrayAdapter<String> {

    Uri uri;

    Activity activity;
    public custom_pdf_class(Activity activity, int resource) {
        super(activity,resource);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.custom_pdffile_loader,null);
        PDFView pdfView=view.findViewById(R.id.pdfView);

        return super.getView(position, convertView, parent);
    }
}
