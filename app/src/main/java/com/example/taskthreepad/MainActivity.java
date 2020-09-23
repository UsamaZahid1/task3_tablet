package com.example.taskthreepad;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskthreepad.Adapter.BtnAdapter;
import com.example.taskthreepad.Adapter.DwBtnAdapter;
import com.example.taskthreepad.Adapter.GroundAdapter;
import com.example.taskthreepad.Adapter.TimeAdapter;
import com.kizitonwose.calendarview.CalendarView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import eightbitlab.com.blurview.BlurView;


public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Dialog dialog;
    BlurView blurView;
    String month;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv_open);
        dialog = new Dialog(this);
        blurView = findViewById(R.id.blurView);
//        blurBackground();


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
//                blurBackground();
            }
        });


    }

    public void showPopup() {
        final RecyclerView recyclerViewButton, recyclerViewGround, recyclerViewTime;
        final ImageView ivClose;
        final Button btnDw;
        final CalendarView calendarView;

        final String data[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        //ground recyclerView data
        final String dataNumber[] = {"TO1", "TO2", "TO3", "TO4", "TO5", "TO6", "TO7", "TO8", "TO9", "TO10"};
        final String dataGround[] = {"Ground Floor", "Ground Floor", "Ground Floor", "Ground Floor", "Ground Floor", "Beer Garden", "Ground Floor",
                "Ground Floor", "Ground Floor", "Ground Floor",};
        final String dataSize[] = {"2-4", "2-4", "2-4", "2-4", "2-4", "2-4", "2-4", "2-4", "2-4", "2-4",};
        final int img[] = {R.drawable.group_2_img, R.drawable.group_2_img, R.drawable.group_2_img, R.drawable.group_2_img,
                R.drawable.group_2_img, R.drawable.group_2_img, R.drawable.group_2_img,
                R.drawable.group_2_img, R.drawable.group_2_img, R.drawable.group_2_img,};
        //third recyclerdata
        final String[] dataTop = {"12:00 pm", "12:30 pm", "1:00 pm", "1:00pm", "12:00 pm", "12:30 pm", "1:00 pm", "1:00pm"};
        final String[] dataBottom = {"1:30 pm", "2:00 pm", "2:30 pm", "3:00pm", "3:30 pm", "4:00 pm", "1:00 pm", "1:00pm"};


        dialog.setContentView(R.layout.activity_second);

        ivClose = dialog.findViewById(R.id.iv_close);
        btnDw = dialog.findViewById(R.id.btn_dw);
        recyclerViewButton = dialog.findViewById(R.id.recyclerview_button);
        recyclerViewGround = dialog.findViewById(R.id.recyclerview_ground);
        recyclerViewTime = dialog.findViewById(R.id.recyclerview_time);
        HashSet<Date> events = new HashSet<>();
        events.add(new Date());

        samples.aalamir.customcalendar.CalendarView cv = ((samples.aalamir.customcalendar.CalendarView)dialog.findViewById(R.id.calendarView));
        cv.updateCalendar(events);

        // assign event handler
        cv.setEventHandler(new samples.aalamir.customcalendar.CalendarView.EventHandler()
        {
            @Override
            public void onDayLongPress(Date date)
            {
                // show returned day
                DateFormat df = SimpleDateFormat.getDateInstance();
                Toast.makeText(MainActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
        });



        //---------------day header----------
//        calendarView.setDayBinder(new DayBinder<DayViewContainer>() {
//            @NonNull
//            @Override
//            public DayViewContainer create(@NonNull View view) {
//                return new DayViewContainer(view);
//            }
//
//            @Override
//            public void bind(@NonNull DayViewContainer container, @NonNull CalendarDay day) {
//                container.textView.setText(Integer.toString(day.getDate().getDayOfMonth()));
//            }
//        });
//
//        calendarView.setHasBoundaries(true);
//        //---------------month header----------
//        calendarView.setMonthHeaderBinder(new MonthHeaderFooterBinder<MonthViewContainer>() {
//            @NotNull
//            @Override
//            public MonthViewContainer create(@NotNull View view) {
//                return new MonthViewContainer(view);
//            }
//
//            @Override
//            public void bind(@NotNull MonthViewContainer viewContainer, @NotNull CalendarMonth calendarMonth) {
//                //    viewContainer.tvMonth.setText(String.valueOf(calendarMonth.component1()));
//
//            }
//        });
//
//
//        YearMonth currentMonth = YearMonth.now();
//        YearMonth firstMonth = currentMonth.minusMonths(20);
//        YearMonth lastMonth = currentMonth.plusMonths(20);
//        DayOfWeek firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
//        calendarView.setup(firstMonth, lastMonth, firstDayOfWeek);
//        calendarView.scrollToMonth(currentMonth);


        //------------------------time recycler  view----------------------------



        recyclerViewTime.setHasFixedSize(true);
        recyclerViewTime.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        TimeAdapter timeAdapter = new TimeAdapter(dataTop, dataBottom);
        recyclerViewTime.setAdapter(timeAdapter);

        //------------------------ground recycler view---------------------------
        recyclerViewGround.setHasFixedSize(true);
        recyclerViewGround.setLayoutManager(new LinearLayoutManager(this));
        GroundAdapter groundAdapter = new GroundAdapter(dataNumber, dataGround, dataSize, img);
        recyclerViewGround.setAdapter(groundAdapter);

        //--------------------button recycler view--------------------
        recyclerViewButton.setHasFixedSize(true);
        recyclerViewButton.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        BtnAdapter adapter = new BtnAdapter(data);
        recyclerViewButton.setAdapter(adapter);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //-------blur------
        Bitmap map = takeScreenShot(MainActivity.this);
        Bitmap fast = fastblur(map, 50);
        final Drawable draw = new BitmapDrawable(getResources(), fast);
        dialog.getWindow().setBackgroundDrawable(draw);

        // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();


        btnDw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dwPopup();

            }
        });

    }

    public void dwPopup() {
        final Dialog dialogdw;
        ImageView ivCut;
        RecyclerView recyclerView;
        String[] dataTop = {"DW", "CM", "KD", "TJ"};
        String[] dataBottom = {"DW", "CC", "DQ", "GT"};

        dialogdw = new Dialog(MainActivity.this);
        dialogdw.setContentView(R.layout.activity_dw);
        recyclerView = dialogdw.findViewById(R.id.recyclerView_dw);
        ivCut = dialogdw.findViewById(R.id.iv_cut);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        DwBtnAdapter adapter = new DwBtnAdapter(dataTop, dataBottom);
        recyclerView.setAdapter(adapter);


        ivCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogdw.dismiss();
            }
        });

        dialogdw.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogdw.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogdw.show();
    }

    public Bitmap fastblur(Bitmap sentBitmap, int radius) {
        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);

        if (radius < 1) {
            return (null);
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int[] pix = new int[w * h];
        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;

        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];

        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }

        yw = yi = 0;

        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;

        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;

            for (x = 0; x < w; x++) {

                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];

                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;

                sir = stack[i + radius];

                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];

                rbs = r1 - Math.abs(i);

                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;

                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }

                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = (0xff000000 & pix[yi]) | (dv[rsum] << 16) | (dv[gsum] << 8) | dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];

                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi += w;
            }
        }

        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.setPixels(pix, 0, w, 0, 0, w, h);

        return (bitmap);
    }

    private static Bitmap takeScreenShot(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();

        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

}

//class DayViewContainer extends ViewContainer {
//    TextView textView;
//
//    DayViewContainer(@NonNull View view) {
//        super(view);
//        textView = view.findViewById(R.id.calendarDayText);
//    }
//}
//
//class MonthViewContainer extends ViewContainer {
//    TextView tvMonth;
//
//    MonthViewContainer(@NonNull View view) {
//        super(view);
//    }
//}