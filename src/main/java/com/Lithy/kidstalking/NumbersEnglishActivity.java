package com.Lithy.kidstalking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Lithy.kidstalking.Adapter.englishnumberAdapter;
import com.Lithy.kidstalking.model.screen_englishnumber;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NumbersEnglishActivity extends AppCompatActivity {


    ViewPager mViewpagerstory;
    englishnumberAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_englishnumber> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_english);


        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);

        items = new ArrayList<>();
        items.add(new screen_englishnumber(R.drawable.one,R.drawable.waheeedd,R.raw.englishone,"One"));
        items.add(new screen_englishnumber(R.drawable.two,R.drawable.atneen,R.raw.englishtwo,"Two"));
        items.add(new screen_englishnumber(R.drawable.three,R.drawable.tlatttttta,R.raw.englishthree,"Three"));
        items.add(new screen_englishnumber(R.drawable.four,R.drawable.arbaaaaaa,R.raw.englishfour,"four"));
        items.add(new screen_englishnumber(R.drawable.five,R.drawable.khmsaaa,R.raw.englishfive,"Five"));
        items.add(new screen_englishnumber(R.drawable.six,R.drawable.staaaa,R.raw.englishsix,"Six"));
        items.add(new screen_englishnumber(R.drawable.seven,R.drawable.sbaaaa,R.raw.englishseven,"Seven"));
        items.add(new screen_englishnumber(R.drawable.eight,R.drawable.thmaniaaa,R.raw.englisheight,"eight"));
        items.add(new screen_englishnumber(R.drawable.nine,R.drawable.tsaaaa,R.raw.englishnine,"nine"));
        items.add(new screen_englishnumber(R.drawable.ten,R.drawable.ashraa,R.raw.englishten,"Ten"));




        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new englishnumberAdapter(this, items);
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
