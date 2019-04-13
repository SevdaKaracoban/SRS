package com.example.srs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private TextView userNameTvw;
    private EditText subjectEdt;
    private Button addSubjectBtn;
    private ListView subjectsLvw;
    private ImageView photoImg;
    private SubjectAdapter adapter;
    private static final int IMAGE_ACTION_CODE = 102;

    //static ArrayList<StudentSubjects> subjectList = new ArrayList<StudentSubjects>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initialize();

    }


    private void initialize() {
        userNameTvw= findViewById(R.id.userNameTvw);
        subjectEdt= findViewById(R.id.subjectEdt);
        addSubjectBtn = findViewById(R.id.addSubjectBtn);
        subjectsLvw = findViewById(R.id.subjectsLvw);
        photoImg = findViewById(R.id.photoImg);

        //get the intent in the target activity
        Intent intent = getIntent();
        //get the attached bundle from the intent
        Bundle extras = intent.getExtras();
        //Extracting the stored data from the bundle
        String name = extras.getString("name");
        userNameTvw.setText(name);

        final SubjectAdapter adapter  = new SubjectAdapter(this,StudentSubjects.getData());
        subjectsLvw.setAdapter(adapter);

        addSubjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentSubjects newSubject = new  StudentSubjects("sevda",String.valueOf(subjectEdt.getText().toString()));
                adapter.add(newSubject);
                subjectEdt.setText("");
            }
        });


        photoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photointent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photointent,IMAGE_ACTION_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode!=RESULT_OK) return;
        //ImageView photoImg= findViewById(R.id.photoImg);
        Bundle extras = data.getExtras();
        ((ImageView)findViewById(R.id.photoImg)).setImageBitmap((Bitmap) extras.get("data"));
    }
}
