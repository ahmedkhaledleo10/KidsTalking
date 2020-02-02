package com.Lithy.kidstalking.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.Lithy.kidstalking.R;
import com.Lithy.kidstalking.model.screen_arabiccolor;

import java.util.List;

public class arabiccolorAdapter extends PagerAdapter {


    Context context;
    List<screen_arabiccolor> items;


    public arabiccolorAdapter(Context context, List<screen_arabiccolor> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.item_arabic_color,null);
        ImageView img_image=view.findViewById(R.id.img_image);
        ImageView img_color=view.findViewById(R.id.img_color);

        img_image.setImageResource(items.get(position).getImg_image());
        img_color.setImageResource(items.get(position).getImg_color());

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
