package com.example.life;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    private List<Comment> mComments = new ArrayList<>();
    private List<com.example.life.Comment> comments;

    public void setComments(List<com.example.life.Comment> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = mComments.get(position);
        holder.bind(comment);
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {

        private TextView mCommentTextView;

        CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            mCommentTextView = itemView.findViewById(R.id.comment_textView);
        }

        void bind(Comment comment) {
            mCommentTextView.setText(comment.getTextContent());
        }
    }
}
