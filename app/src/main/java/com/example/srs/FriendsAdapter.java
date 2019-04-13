package com.example.srs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.MyViewHolder> {
    ArrayList<StudentFriends> friendsList;
    LayoutInflater inflater;
    private ItemClickListener clickListener;

    /*private ItemClickListener onItemClickListener;

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        onItemClickListener = clickListener;
    }*/



    public FriendsAdapter(FriendsActivity activity, ArrayList<StudentFriends> fList) {
        inflater = LayoutInflater.from(activity);
        this.friendsList = fList;

    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

   /* public FriendsAdapter(FriendsActivity activity, ArrayList<StudentFriends> fList,ItemClickListener clickListener) {
        inflater = LayoutInflater.from(activity);
        this.friendsList = fList;
        onItemClickListener = clickListener;

    }*/

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.friends_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder( view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        StudentFriends selectedFriends = friendsList.get(position);
        myViewHolder.setData(selectedFriends, position);

    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }



    class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {



        TextView friendsNameTvw, friendsUserNameTvw;
        ImageView friendsImg;

        public MyViewHolder(View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);
            friendsNameTvw = itemView.findViewById(R.id.friendsnameTvw);
            friendsUserNameTvw = itemView.findViewById(R.id.friendsusernameTvw);
            friendsImg = itemView.findViewById(R.id.friendsphotoImg);

            itemView.setOnClickListener(this);


            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view,getAdapterPosition());
                }
            });*/
        }

        public void setData(StudentFriends selectedFriends, int position) {
            this.friendsNameTvw.setText(selectedFriends.getFriendsname());
            this.friendsUserNameTvw.setText(selectedFriends.getFriendsusername());
        }

        @Override
        public void onClick(View v) {

            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
            //clickListener.onClick(v, getLayoutPosition());
            Log.d(TAG, "onClick: " + getLayoutPosition());
            /*if (v.getId() == R.id.deleteperson)
                deletePerson(getLayoutPosition());*/


        }


    }

}
