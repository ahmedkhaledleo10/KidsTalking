package com.Lithy.kidstalking;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.Lithy.kidstalking.Adapter.arabhunstoryAdapter;
import com.Lithy.kidstalking.model.screen_arab;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ArabStory1Activity extends AppCompatActivity {

     ViewPager mViewpagerstory;
     arabhunstoryAdapter adapter;
     int position = 0;
     ImageView imgnext;
     ImageView imgback;
     TabLayout TabIndicator;
     List<screen_arab> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arab_story1);


        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);

        items = new ArrayList<>();
        items.add(new screen_arab(R.drawable.pagearab1));
        items.add(new screen_arab(R.drawable.pagearab2));
        items.add(new screen_arab(R.drawable.pagearab3));
        items.add(new screen_arab(R.drawable.pagearab4));
        items.add(new screen_arab(R.drawable.pagearab5));
        items.add(new screen_arab(R.drawable.pagearab6));
        items.add(new screen_arab(R.drawable.pagearab7));
        items.add(new screen_arab(R.drawable.pagearab8));
        items.add(new screen_arab(R.drawable.pagearab9));
        items.add(new screen_arab(R.drawable.pagearab10));
        items.add(new screen_arab(R.drawable.pagearab11));
        items.add(new screen_arab(R.drawable.pagearab12));
        items.add(new screen_arab(R.drawable.pagearab13));
        items.add(new screen_arab(R.drawable.pagearab14));
        items.add(new screen_arab(R.drawable.pagearab15));


        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new arabhunstoryAdapter(this, items);
        mViewpagerstory.setAdapter(adapter);


        TabIndicator.setupWithViewPager(mViewpagerstory);


        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int item = mViewpagerstory.getCurrentItem();
                if (item > 0) {
                    item = item - 1;
                    mViewpagerstory.setCurrentItem(item);
                }
            }
        });

        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int item = mViewpagerstory.getCurrentItem();


                if (item < adapter.getCount() - 1) {
                    item = item + 1;
                    mViewpagerstory.setCurrentItem(item);
                }

            }
        });

    }
}
