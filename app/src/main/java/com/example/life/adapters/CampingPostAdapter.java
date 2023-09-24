package com.example.life.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.life.LikeBoard;
import com.example.life.R;
import com.example.life.models.CampingPost;

import java.util.ArrayList;
import java.util.List;

public class CampingPostAdapter extends RecyclerView.Adapter<CampingPostAdapter.CampingPostViewHolder> {

    private List<CampingPost> campingPostList = new ArrayList<>();

    public void setCampingPostList(List<CampingPost> campingPosts) {
        campingPostList = campingPosts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CampingPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new CampingPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CampingPostViewHolder holder, int position) {
        CampingPost data = campingPostList.get(position);
        holder.bind(data, position);
    }

    @Override
    public int getItemCount() {
        return campingPostList.size();
    }

    public void addPost(CampingPost post) {
        campingPostList.add(post);
        notifyDataSetChanged();
    }

    static class CampingPostViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView nicknameTextView;
        private TextView contentsTextView;
        private TextView dateTextView;
        private Button likeButton;

        CampingPostViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.item_post_title);
            nicknameTextView = itemView.findViewById(R.id.item_post_nickname);
            contentsTextView = itemView.findViewById(R.id.item_post_contents);
            dateTextView = itemView.findViewById(R.id.item_post_date);
            likeButton = itemView.findViewById(R.id.comment_button);
        }

        void bind(CampingPost data, final int position) {
            titleTextView.setText(data.getTitle());
            nicknameTextView.setText("작성자: " + data.getNickname());
            contentsTextView.setText(data.getContents());
            dateTextView.setText((CharSequence) data.getDate());

        }
    }
}
