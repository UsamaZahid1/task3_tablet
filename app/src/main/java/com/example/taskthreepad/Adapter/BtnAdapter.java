package com.example.taskthreepad.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskthreepad.R;


public class BtnAdapter extends RecyclerView.Adapter<BtnAdapter.BtnViewHolder> {

    private String data[];
    int row_index=-1;

    public BtnAdapter(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public BtnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.btn_list_row, parent, false);

        return new BtnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BtnViewHolder holder, final int position) {

        String num = data[position];
        holder.btn.setText(num);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position) {

            holder.btn.setBackground(holder.btn.getResources().getDrawable(R.drawable.button_pink));
        }
        else{
            holder.btn.setBackground(holder.btn.getResources().getDrawable(R.drawable.button_transparent));
        }
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class BtnViewHolder extends RecyclerView.ViewHolder {
        Button btn;
        View mView;

        public BtnViewHolder(@NonNull View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btn_btnlist);
            mView = itemView;


        }
    }
}
