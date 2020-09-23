package com.example.taskthreepad.Adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskthreepad.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DwBtnAdapter extends RecyclerView.Adapter<DwBtnAdapter.DwBtnViewHolder> {


    private String[] dataTop, dataBottom;
    int row_indexTop = -1;
    int row_indexBottom = -1;

    public DwBtnAdapter(String[] dataTop, String[] dataBottom) {
        this.dataTop = dataTop;
        this.dataBottom = dataBottom;
    }

    @NonNull
    @Override
    public DwBtnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dw_button_list, parent, false);

        return new DwBtnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DwBtnViewHolder holder, final int position) {

        String top = dataTop[position];
        String bottom = dataBottom[position];

        holder.btnTop.setText(top);
        holder.btnBottom.setText(bottom);


        List<String> colors;

        colors = new ArrayList<String>();

        colors.add("#5E97F6");
        colors.add("#9CCC65");
        colors.add("#FF8A65");
        colors.add("#9E9E9E");
        colors.add("#9FA8DA");
        colors.add("#90A4AE");
        colors.add("#AED581");
        colors.add("#F6BF26");
        colors.add("#FFA726");
        colors.add("#4DD0E1");
        colors.add("#BA68C8");
        colors.add("#A1887F");

// all colors used by gmail application :) may be,

        // genrating random num from 0 to 11 because you can add more or less

        Random r = new Random();
        int i1 = r.nextInt(11 - 0) + 0;

//genrating shape with colors

        GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.OVAL);
        draw.setStroke(8, Color.GRAY);
        draw.setColor(Color.parseColor(colors.get(i1)));

        GradientDrawable grad = new GradientDrawable();
        grad.setStroke(8, Color.WHITE);
        grad.setShape(GradientDrawable.OVAL);
        grad.setColor(Color.parseColor(colors.get(i1)));
// assigning to textview
        //textview
        holder.btnBottom.setBackground(draw); //textview
        holder.btnTop.setBackground(draw);


            holder.btnTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_indexTop = position;
                    notifyDataSetChanged();

                }
            });
            if (row_indexTop == position) {

                holder.btnTop.setBackgroundDrawable(grad);
            }
            else{
                holder.btnTop.setBackground(draw);
            }

            holder.btnBottom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_indexBottom = position;
                    notifyDataSetChanged();

                }
            });
            if (row_indexBottom == position) {

                holder.btnBottom.setBackgroundDrawable(grad);
            }
            else{
                holder.btnBottom.setBackground(draw);
            }

        }


    @Override
    public int getItemCount() {
        return dataTop.length;
    }

    public static class DwBtnViewHolder extends RecyclerView.ViewHolder {
        Button btnTop, btnBottom;

        public DwBtnViewHolder(@NonNull View itemView) {
            super(itemView);
            btnTop = itemView.findViewById(R.id.btn_dwlist_top);
            btnBottom = itemView.findViewById(R.id.btn_dwlist_bottom);
        }
    }
}
