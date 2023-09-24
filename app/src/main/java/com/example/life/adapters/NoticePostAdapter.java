package com.example.life.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.life.Notice;
import com.example.life.R;
import com.example.life.models.Post;

import java.util.List;

public class NoticePostAdapter extends RecyclerView.Adapter<NoticePostAdapter.PostViewHolder>{

    private List<Post> datas;

    public NoticePostAdapter(List<Post> datas){
        this.datas = datas;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post data = datas.get(position);
        holder.nicname.setText("작성자: " + data.getNicname());
        holder.title.setText(data.getTitle());
        holder.contents.setText(data.getContents());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setOnItemClickListener(Notice notice) {
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView nicname;
        private TextView title;
        private TextView contents;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            nicname = itemView.findViewById(R.id.item_post_nicname);
            title = itemView.findViewById(R.id.item_post_title);
            contents = itemView.findViewById(R.id.item_post_contents);
        }
    }
}
