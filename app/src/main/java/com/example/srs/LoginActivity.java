package com.example.srs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    EditText userNameEdt;
    EditText passwordEdt;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }


    private void initialize() {
        loginBtn = findViewById(R.id.loginBtn);
        userNameEdt= findViewById(R.id.userNameEdt);
        passwordEdt= findViewById(R.id.passwordEdt);
        final Student student= new Student("sevda","123","Sevda Kara");
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userNameEdt.getText().toString().equals("sevda") && passwordEdt.getText().toString().equals("123")) {

                    Intent mainintent = new Intent(LoginActivity.this,MainActivity.class);
                    Bundle extras = new Bundle();
                    extras.putString("name",student.getName().toString());
                    mainintent.putExtras(extras);
                    startActivity(mainintent);
                }else
                    Toast.makeText(getApplicationContext(),"KullanıcıAdı veya Paralo yanlış",Toast.LENGTH_LONG).show();

            }
        });

    }
}
