package com.example.srs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectAdapter extends ArrayAdapter<StudentSubjects> {

    public SubjectAdapter(Context context,ArrayList<StudentSubjects> subjectsList) {
        super(context,0,subjectsList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        StudentSubjects studentSubject = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.line_layout, parent, false);
        }
        // Lookup view for data population
        ImageView icomImg = (ImageView) convertView.findViewById(R.id.iconImg);
        TextView subjectTvw = (TextView) convertView.findViewById(R.id.subjectTvw);
        // Populate the data into the template view using the data object
        //icomImg.setText(user.name);
        subjectTvw.setText(studentSubject.getSubject());
        // Return the completed view to render on screen
        return convertView;
    }
}
