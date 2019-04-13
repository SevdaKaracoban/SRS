package com.example.srs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class FriendsActivity extends AppCompatActivity implements ItemClickListener {
    RecyclerView recyclerView;
    Button addFriendsBtn;
    EditText friendsnameEdt,friendsusernameEdt;
    List<StudentFriends> studentFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        initialize();
    }

    private void initialize() {
        recyclerView = findViewById(R.id.friendsRcw);
        addFriendsBtn = findViewById(R.id.addfriendBtn);
        friendsnameEdt = findViewById(R.id.friendsnameEdt);
        friendsusernameEdt = findViewById(R.id.friendsusernameEdt);

        studentFriends= StudentFriends.getData();

        final FriendsAdapter friendsListAdapter = new FriendsAdapter(this,StudentFriends.getData());
        recyclerView.setAdapter(friendsListAdapter);
        friendsListAdapter.setClickListener(this);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(linearLayoutManager);


        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        addFriendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (! friendsnameEdt.getText().equals("")) {
                    StudentFriends newFriend = new StudentFriends("sevda", friendsnameEdt.getText().toString(), friendsusernameEdt.getText().toString());
                    studentFriends.add(newFriend);
                    friendsListAdapter.friendsList.add(newFriend);
                    friendsListAdapter.notifyDataSetChanged();
                    //adapter.add(newFriend);
                    friendsnameEdt.setText("");
                    friendsusernameEdt.setText("");
                }
            }
        });


    }

    @Override
    public void onClick(View view, int position) {
        final StudentFriends friends = studentFriends.get(position);
        Intent i = new Intent(this, ProfileActivity.class);
        Bundle extras = new Bundle();
        extras.putString("name",friends.getFriendsname().toString());
        i.putExtras(extras);

        startActivity(i);
    }
}
