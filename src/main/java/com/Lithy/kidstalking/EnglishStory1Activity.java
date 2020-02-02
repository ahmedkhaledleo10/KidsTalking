package com.Lithy.kidstalking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Lithy.kidstalking.Adapter.engfishAdapter;
import com.Lithy.kidstalking.model.screen_eng2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class EnglishStory1Activity extends AppCompatActivity {

    ViewPager mViewpagerstory;
    engfishAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_eng2> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_story1);


        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);


        items = new ArrayList<>();
        items.add(new screen_eng2(R.drawable.fishpage1));
        items.add(new screen_eng2(R.drawable.fishpage2));
        items.add(new screen_eng2(R.drawable.fishpage3));
        items.add(new screen_eng2(R.drawable.fishpage4));
        items.add(new screen_eng2(R.drawable.fishpage5));
        items.add(new screen_eng2(R.drawable.fishpage6));
        items.add(new screen_eng2(R.drawable.fishpage7));
        items.add(new screen_eng2(R.drawable.fishpage8));
        items.add(new screen_eng2(R.drawable.fishpage9));
        items.add(new screen_eng2(R.drawable.fishpage10));
        items.add(new screen_eng2(R.drawable.fishpage11));




        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new engfishAdapter(this, items);
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
