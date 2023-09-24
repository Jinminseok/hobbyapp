package com.example.life;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LikedPostsAdapter extends RecyclerView.Adapter<LikedPostsAdapter.LikedPostViewHolder> {

    private List<String> likedPosts;

    public LikedPostsAdapter(List<String> likedPosts) {
        this.likedPosts = likedPosts;
    }

    @NonNull
    @Override
    public LikedPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_liked_post, parent, false);
        return new LikedPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikedPostViewHolder holder, int position) {
        String postTitle = likedPosts.get(position);
        holder.bind(postTitle);
    }

    @Override
    public int getItemCount() {
        return likedPosts.size();
    }

    static class LikedPostViewHolder extends RecyclerView.ViewHolder {

        private TextView postTitleTextView;

        public LikedPostViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitleTextView = itemView.findViewById(R.id.post_title_textView);
        }

        public void bind(String postTitle) {
            postTitleTextView.setText(postTitle);
        }
    }
}
