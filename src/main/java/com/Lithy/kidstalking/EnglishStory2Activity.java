package com.Lithy.kidstalking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Lithy.kidstalking.Adapter.engfoxAdapter;
import com.Lithy.kidstalking.model.screen_eng;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class EnglishStory2Activity extends AppCompatActivity {

    ViewPager mViewpagerstory;
    engfoxAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_eng> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_story2);


        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);


        items = new ArrayList<>();
        items.add(new screen_eng(R.drawable.thefox1));
        items.add(new screen_eng(R.drawable.thefox2));
        items.add(new screen_eng(R.drawable.thefox3));
        items.add(new screen_eng(R.drawable.thefox4));
        items.add(new screen_eng(R.drawable.thefox5));
        items.add(new screen_eng(R.drawable.thefox6));
        items.add(new screen_eng(R.drawable.thefox7));
        items.add(new screen_eng(R.drawable.thefox8));
        items.add(new screen_eng(R.drawable.thefox9));
        items.add(new screen_eng(R.drawable.thefox10));
        items.add(new screen_eng(R.drawable.thefox11));



        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new engfoxAdapter(this, items);
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
