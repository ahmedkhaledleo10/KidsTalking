package com.Lithy.kidstalking.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.Lithy.kidstalking.R;
import com.Lithy.kidstalking.model.screen_englishnumber;

import java.util.List;

public class englishnumberAdapter extends PagerAdapter {


    Context context;
    List<screen_englishnumber> items;

    public englishnumberAdapter(Context context, List<screen_englishnumber> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.item_english_number,null);
        ImageView imgcount=view.findViewById(R.id.img_count);
        ImageView imgnumber=view.findViewById(R.id.img_number);
        TextView number=view.findViewById(R.id.txt_number);

        imgcount.setImageResource(items.get(position).getImg_count());
        imgnumber.setImageResource(items.get(position).getImg_number());
        number.setText(items.get(position).getNumber());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(context, items.get(position).getAudio());
                mediaPlayer.start();
            }
        });

        container.addView(view);

        return view;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
