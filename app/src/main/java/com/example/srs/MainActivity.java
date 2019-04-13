package com.example.srs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button profileBtn,friendsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {

        profileBtn = findViewById(R.id.profileBtn);
        friendsBtn = findViewById(R.id.friendsBtn);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileintent = new Intent(MainActivity.this,ProfileActivity.class);
                Bundle extras = new Bundle();
                extras.putString("name",getIntent().getStringExtra("name").toString());
                profileintent.putExtras(extras);
                startActivity(profileintent);

            }
        });



        friendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friendsintent = new Intent(MainActivity.this,FriendsActivity.class);
                startActivity(friendsintent);
            }
        });
    }


}
