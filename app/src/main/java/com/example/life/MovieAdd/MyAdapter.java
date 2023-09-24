package com.example.life.MovieAdd;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.life.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<Dataclass> dataList2;

    public MyAdapter(Context context, List<Dataclass> dataList) {
        this.context = context;
        this.dataList2 = dataList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_admin_movie_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList2.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList2.get(position).getDataTitle());
        holder.recDesc.setText(dataList2.get(position).getDataDesc());
        holder.recLang.setText(dataList2.get(position).getDataLang());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieBoard.class);
                intent.putExtra("Image", dataList2.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Description", dataList2.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("Title", dataList2.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Key",dataList2.get(holder.getAdapterPosition()).getKey());
                intent.putExtra("Language", dataList2.get(holder.getAdapterPosition()).getDataLang());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList2.size();
    }

    public void searchDataList(ArrayList<Dataclass> searchList2){
        dataList2 = searchList2;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recDesc = itemView.findViewById(R.id.recDesc);
        recLang = itemView.findViewById(R.id.recLang);
        recTitle = itemView.findViewById(R.id.recTitle);
    }
}