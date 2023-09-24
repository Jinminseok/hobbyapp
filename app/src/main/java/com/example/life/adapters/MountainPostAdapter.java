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
import com.example.life.models.MountainPost;

import java.util.ArrayList;
import java.util.List;

public class MountainPostAdapter extends RecyclerView.Adapter<MountainPostAdapter.MountainPostViewHolder> {

    private List<MountainPost> mountainPostList = new ArrayList<>();

    public void setMountainPostList(List<MountainPost> mountainPosts) {
        mountainPostList = mountainPosts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MountainPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new MountainPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MountainPostViewHolder holder, int position) {
        MountainPost data = mountainPostList.get(position);
        holder.bind(data, position);
    }

    @Override
    public int getItemCount() {
        return mountainPostList.size();
    }

    public void addPost(MountainPost post) {
        mountainPostList.add(post);
        notifyDataSetChanged();
    }

    static class MountainPostViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView nicknameTextView;
        private TextView contentsTextView;
        private TextView dateTextView;
        private Button likeButton;

        MountainPostViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.item_post_title);
            nicknameTextView = itemView.findViewById(R.id.item_post_nickname);
            contentsTextView = itemView.findViewById(R.id.item_post_contents);
            dateTextView = itemView.findViewById(R.id.item_post_date);
            likeButton = itemView.findViewById(R.id.comment_button);
        }

        void bind(MountainPost data, final int position) {
            titleTextView.setText(data.getTitle());
            nicknameTextView.setText("작성자: " + data.getNickname());
            contentsTextView.setText(data.getContents());
            dateTextView.setText((CharSequence) data.getDate());

        }
    }
}
