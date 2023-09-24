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
import com.example.life.models.FishingPost;

import java.util.ArrayList;
import java.util.List;

public class FishingPostAdapter extends RecyclerView.Adapter<FishingPostAdapter.FishingPostViewHolder> {

    private List<FishingPost> fishingPostList = new ArrayList<>();

    public void setFishingPostList(List<FishingPost> fishingPosts) {
        fishingPostList = fishingPosts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FishingPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new FishingPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishingPostViewHolder holder, int position) {
        FishingPost data = fishingPostList.get(position);
        holder.bind(data, position);
    }

    @Override
    public int getItemCount() {
        return fishingPostList.size();
    }

    public void addPost(FishingPost post) {
        fishingPostList.add(post);
        notifyDataSetChanged();
    }

    static class FishingPostViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView nicknameTextView;
        private TextView contentsTextView;
        private TextView dateTextView;
        private Button likeButton;

        FishingPostViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.item_post_title);
            nicknameTextView = itemView.findViewById(R.id.item_post_nickname);
            contentsTextView = itemView.findViewById(R.id.item_post_contents);
            dateTextView = itemView.findViewById(R.id.item_post_date);
            likeButton = itemView.findViewById(R.id.comment_button);
        }

        void bind(FishingPost data, final int position) {
            titleTextView.setText(data.getTitle());
            nicknameTextView.setText("작성자: " + data.getNickname());
            contentsTextView.setText(data.getContents());
            dateTextView.setText((CharSequence) data.getDate());

        }
    }
}
