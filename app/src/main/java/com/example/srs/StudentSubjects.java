package com.example.srs;

import java.util.ArrayList;

public class StudentSubjects {
    private String  username;
    private String subject;

    public StudentSubjects(String username, String subject) {
        this.username = username;
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static ArrayList<StudentSubjects> getData() {
        ArrayList<StudentSubjects> subjectList = new ArrayList<StudentSubjects>();
        subjectList.add(new StudentSubjects( "sevda.kara", "Matematik"));
        subjectList.add(new StudentSubjects( "sevda.kara", "Algoritma"));
        subjectList.add(new StudentSubjects( "sevda.kara", "Elektronik"));
        return subjectList;
    }

}
