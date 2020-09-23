package com.example.taskthreepad.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskthreepad.R;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeViewHolder> {

    String[] dataTop, dataBottom;
    int row_index_top=-1;
    int row_index_bottom=-1;

    public TimeAdapter(String[] dataTop, String[] dataBottom) {
        this.dataTop = dataTop;
        this.dataBottom = dataBottom;
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_list, parent, false);


        return new TimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, final int position) {
        String top=dataTop[position];
        String bottom=dataBottom[position];


        holder.btnTop.setText(top);
        holder.btnBottom.setText(top);

        holder.btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index_top=position;
                notifyDataSetChanged();
            }
        });

        if(row_index_top==position) {

            holder.btnTop.setBackground(holder.btnTop.getResources().getDrawable(R.drawable.button_pink));
        }
        else{
            holder.btnTop.setBackground(holder.btnTop.getResources().getDrawable(R.drawable.button_transparent));
        }


        holder.btnBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index_bottom=position;
                notifyDataSetChanged();
            }
        });
        if(row_index_bottom==position) {

            holder.btnBottom.setBackground(holder.btnBottom.getResources().getDrawable(R.drawable.button_pink));
        }
        else{
            holder.btnBottom.setBackground(holder.btnBottom.getResources().getDrawable(R.drawable.button_transparent));
        }


    }

    @Override
    public int getItemCount() {
        return dataTop.length;
    }

    public static class TimeViewHolder extends RecyclerView.ViewHolder {
        Button btnTop, btnBottom;

        public TimeViewHolder(@NonNull View itemView) {
            super(itemView);
            btnTop = itemView.findViewById(R.id.btn_time_top);
            btnBottom = itemView.findViewById(R.id.btn_time_bottom);
        }
    }
}
