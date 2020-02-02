package com.Lithy.kidstalking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.Lithy.kidstalking.R;
import com.Lithy.kidstalking.model.screen_arab;

import java.util.List;

public class arabhunstoryAdapter extends PagerAdapter {

    Context context;
    List<screen_arab>items;

    public arabhunstoryAdapter(Context context, List<screen_arab> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.item_arabhunstory,null);

        ImageView imgstory=view.findViewById(R.id.img_cover);
        imgstory.setImageResource(items.get(position).getImg_storyarab());

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
