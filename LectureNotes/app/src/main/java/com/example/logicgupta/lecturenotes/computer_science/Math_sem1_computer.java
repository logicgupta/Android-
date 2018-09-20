package com.example.logicgupta.lecturenotes.computer_science;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.logicgupta.lecturenotes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Math_sem1_computer extends AppCompatActivity {
    Button upload1,select1,download1;
    Uri fileurl;
    ProgressDialog progressDialog;
    FirebaseDatabase database;
    StorageReference storageReference;
    String filename;
    FirebaseStorage storage;
    Bundle bundle;
    String branch;
    String semester;
    String subject;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_computer_sem1_math);
        upload1=findViewById(R.id.upload1);
        select1=findViewById(R.id.select1);
        database=FirebaseDatabase.getInstance();
        download1=findViewById(R.id.download1);
        bundle=getIntent().getExtras();
        semester=bundle.getString("semester");
        subject=bundle.getString("subject");
        branch=bundle.getString("branch");
        select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFile();
            }
        });
        upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadfile(fileurl,filename);
            }
        });
        download1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Math_sem1_computer.this,MyRecycler_View.class);
                intent.putExtra("branch",branch);
                intent.putExtra("semester",semester);
                intent.putExtra("subject",subject);
                startActivity(intent);
            }
        });
    }

    private void uploadfile(Uri fileurl, final String filename) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Uploading ...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        if(fileurl!=null){
            storage=FirebaseStorage.getInstance();
            storageReference=storage.getReference();
            Log.d(" MATH SEM1 COMPUTER","Error 1");
            storageReference.child(semester).child(subject).child(filename).putFile(fileurl)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Log.d(" MATH SEM1 COMPUTER","REALTIME DATABASE ERROR 1");
                            String url=taskSnapshot.getDownloadUrl().toString();
                            DatabaseReference databaseReference=database.getReference("Files\\"+branch+"\\"+semester+"\\"+subject);
                            databaseReference.child(filename).setValue(url)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(Math_sem1_computer.this, "Succsesfully Uploaded", Toast.LENGTH_SHORT).show();
                                                progressDialog.dismiss();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Math_sem1_computer.this, "Plaese Try Again !", Toast.LENGTH_SHORT).show();
                                            progressDialog.dismiss();
                                        }
                                    });

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            int currentprogress= (int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            progressDialog.setProgress(currentprogress);

                        }
                    });




        }
        else{
            Toast.makeText(this, "Please Select File", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    }

    private void selectFile() {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK && data!=null){
            fileurl=data.getData();
            Cursor returnCursor =
                    getContentResolver().query(fileurl, null, null, null, null);
            /*
             * Get the column indexes of the data in the Cursor,
             * move to the first row in the Cursor, get the data,
             * and display it.
             */
            int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            returnCursor.moveToFirst();
            filename=returnCursor.getString(nameIndex);
            filename=filename.substring(0,filename.lastIndexOf("."));
            Toast.makeText(this, ""+filename, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Please Select the File", Toast.LENGTH_SHORT).show();
        }
    }
}
