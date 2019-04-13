package com.example.srs;

import java.util.ArrayList;

public class StudentFriends {
    private String username;
    private String friendsname;
    private String friendsusername;

    public StudentFriends(String username, String friendsname, String friendsusername) {
        this.username = username;
        this.friendsname = friendsname;
        this.friendsusername = friendsusername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriendsname() {
        return friendsname;
    }

    public void setFriendsname(String friendsname) {
        this.friendsname = friendsname;
    }

    public String getFriendsusername() {
        return friendsusername;
    }

    public void setFriendsusername(String friendsusername) {
        this.friendsusername = friendsusername;
    }

    public static ArrayList<StudentFriends> getData() {
        ArrayList<StudentFriends> friendsList = new ArrayList<StudentFriends>();
        friendsList.add(new StudentFriends( "sevda", "Bengü Çağlayan","@bengu"));
        friendsList.add(new StudentFriends( "sevda", "Derya Demirbaş","@derya"));
        friendsList.add(new StudentFriends( "sevda", "Koray Koca","@koray"));

        return friendsList;
    }

}
