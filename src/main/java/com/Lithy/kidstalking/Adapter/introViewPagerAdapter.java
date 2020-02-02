package com.Lithy.kidstalking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.Lithy.kidstalking.R;
import com.Lithy.kidstalking.model.screenItem;

import java.util.List;

public class introViewPagerAdapter extends PagerAdapter {

    Context mcontext;
    List<screenItem> items;


    public introViewPagerAdapter(Context mcontext, List<screenItem> items) {
        this.mcontext = mcontext;
        this.items = items;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.intro2_layout,null);

        ImageView imgapple=view.findViewById(R.id.img_intro_apple);
        TextView txttitle=view.findViewById(R.id.txt_introtitle);
        TextView txtdesc=view.findViewById(R.id.txt_intro_description);

        txttitle.setText(items.get(position).getTitle());
        txtdesc.setText(items.get(position).getDescription());
        imgapple.setImageResource(items.get(position).getScreenImg());

        container.addView(view);

        return view;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
