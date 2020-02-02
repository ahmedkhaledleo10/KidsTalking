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
import com.Lithy.kidstalking.model.screen_letterenglish;

import java.util.List;

public class engletterAdapter extends PagerAdapter {

    Context context;
    List<screen_letterenglish> items;

    public engletterAdapter(Context context, List<screen_letterenglish> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.item_letter_english,null);
        ImageView imganimal=view.findViewById(R.id.img_animal);
        ImageView imgletter=view.findViewById(R.id.img_letter);
        TextView letter=view.findViewById(R.id.txt_letter);

        imganimal.setImageResource(items.get(position).getImg_animal());
        imgletter.setImageResource(items.get(position).getImg_letter());
        letter.setText(items.get(position).getLetter());

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
