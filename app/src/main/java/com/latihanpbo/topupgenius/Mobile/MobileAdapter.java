package com.latihanpbo.topupgenius.Mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.latihanpbo.topupgenius.R;

import java.util.List;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.ViewHolder>{
    private List<ModelMobile> dataList;
    private OnItemClickListener listener;

    public MobileAdapter(List<ModelMobile> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MobileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_game, parent, false);
        return new MobileAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelMobile item = dataList.get(position);
        holder.imageView.setImageResource(item.getImageGame());
        holder.textView.setText(item.getTvGame());
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageGame);
            textView = itemView.findViewById(R.id.tvGame);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if(listener != null && position != RecyclerView.NO_POSITION){
                    listener.onItemClick(dataList.get(position));
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(ModelMobile modelMobile);
    }

    public void setOnItemClickListener(MobileAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }
}
