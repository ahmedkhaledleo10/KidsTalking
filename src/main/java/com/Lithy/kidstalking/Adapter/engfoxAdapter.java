package com.Lithy.kidstalking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.Lithy.kidstalking.R;
import com.Lithy.kidstalking.model.screen_eng;

import java.util.List;

public class engfoxAdapter extends PagerAdapter {

    Context context;
    List<screen_eng> items;

    public engfoxAdapter(Context context, List<screen_eng> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.englishfoxstory,null);

        ImageView imgstory=view.findViewById(R.id.img_engcover);
        imgstory.setImageResource(items.get(position).getImg_storyeng());

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
