package com.example.taskthreepad.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskthreepad.R;

public class GroundAdapter extends RecyclerView.Adapter<GroundAdapter.GroundViewHolder> {

    private String[] dataNumber, dataGround, dataSize;
    private int[] img;
    int row_index=-1;

    public GroundAdapter(String[] dataNumber, String[] dataGround, String[] dataSize, int[] img) {
        this.dataNumber = dataNumber;
        this.dataGround = dataGround;
        this.dataSize = dataSize;
        this.img = img;
    }

    @NonNull
    @Override
    public GroundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ground_list, parent, false);
        return new GroundViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroundViewHolder holder, final int position) {
        String dataNum=dataNumber[position];
        String datasize=dataSize[position];
        String dataground=dataGround[position];

        holder.tvNumber.setText(dataNum);
        holder.tvSize.setText(datasize);
        holder.tvGround.setText(dataground);
        holder.ivGroup.setImageResource(img[position]);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position) {

            holder.relativeLayout.setBackgroundColor(holder.relativeLayout.getResources().getColor(R.color.colorPrimary));
        }
        else{
            holder.relativeLayout.setBackgroundColor(holder.relativeLayout.getResources().getColor(R.color.transparent));
        }

    }

    @Override
    public int getItemCount() {
        return dataNumber.length;
    }

    public static class GroundViewHolder extends RecyclerView.ViewHolder {

        TextView tvNumber, tvSize, tvGround;
        ImageView ivGroup;
        RelativeLayout relativeLayout;

        public GroundViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber=itemView.findViewById(R.id.tv_number);
            tvSize=itemView.findViewById(R.id.tv_size);
            tvGround=itemView.findViewById(R.id.tv_ground);
            ivGroup=itemView.findViewById(R.id.iv_group);
            relativeLayout=itemView.findViewById(R.id.relative_layout);
        }
    }
}
