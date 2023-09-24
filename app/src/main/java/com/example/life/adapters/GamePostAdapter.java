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
import com.example.life.models.GamePost;

import java.util.ArrayList;
import java.util.List;

public class GamePostAdapter extends RecyclerView.Adapter<GamePostAdapter.GamePostViewHolder> {

    private List<GamePost> gamePostList = new ArrayList<>();

    public void setGamePostList(List<GamePost> gamePosts) {
        gamePostList = gamePosts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GamePostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new GamePostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamePostViewHolder holder, int position) {
        GamePost data = gamePostList.get(position);
        holder.bind(data, position);
    }

    @Override
    public int getItemCount() {
        return gamePostList.size();
    }

    public void addPost(GamePost post) {
        gamePostList.add(post);
        notifyDataSetChanged();
    }

    static class GamePostViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView nicknameTextView;
        private TextView contentsTextView;
        private TextView dateTextView;
        private Button likeButton;

        GamePostViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.item_post_title);
            nicknameTextView = itemView.findViewById(R.id.item_post_nickname);
            contentsTextView = itemView.findViewById(R.id.item_post_contents);
            dateTextView = itemView.findViewById(R.id.item_post_date);
            likeButton = itemView.findViewById(R.id.comment_button);
        }

        void bind(GamePost data, final int position) {
            titleTextView.setText(data.getTitle());
            nicknameTextView.setText("작성자: " + data.getNickname());
            contentsTextView.setText(data.getContents());
            dateTextView.setText((CharSequence) data.getDate());

        }
    }
}
