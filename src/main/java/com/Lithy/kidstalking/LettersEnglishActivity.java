package com.Lithy.kidstalking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Lithy.kidstalking.Adapter.engletterAdapter;
import com.Lithy.kidstalking.model.screen_letterenglish;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LettersEnglishActivity extends AppCompatActivity {

    ViewPager mViewpagerstory;
    engletterAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_letterenglish> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_english);


        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);

        items = new ArrayList<>();
        items.add(new screen_letterenglish(R.drawable.apple,R.drawable.a,R.raw.englishapple,"Apple"));
        items.add(new screen_letterenglish(R.drawable.banana,R.drawable.b,R.raw.englishbanana,"Banana"));
        items.add(new screen_letterenglish(R.drawable.cat,R.drawable.c,R.raw.englishcat,"Cat"));
        items.add(new screen_letterenglish(R.drawable.dog,R.drawable.d,R.raw.englishdog,"dog"));
        items.add(new screen_letterenglish(R.drawable.elephant,R.drawable.e,R.raw.englishelephant,"elephant"));
        items.add(new screen_letterenglish(R.drawable.fish,R.drawable.f,R.raw.englishfish,"Fish"));
        items.add(new screen_letterenglish(R.drawable.giraffe,R.drawable.g,R.raw.englishgiraffe,"giraffe"));
        items.add(new screen_letterenglish(R.drawable.horse,R.drawable.h,R.raw.englishhorse,"horse"));
        items.add(new screen_letterenglish(R.drawable.icecream,R.drawable.i,R.raw.englishicecream,"ice Cream"));
        items.add(new screen_letterenglish(R.drawable.jam,R.drawable.j,R.raw.englishjam,"jam"));
        items.add(new screen_letterenglish(R.drawable.kangaroo,R.drawable.k,R.raw.englishkangaro,"Kangaroo"));
        items.add(new screen_letterenglish(R.drawable.lemon,R.drawable.l,R.raw.englishlemon,"Lemon"));
        items.add(new screen_letterenglish(R.drawable.monkey,R.drawable.m,R.raw.englishmonkey,"Monkey"));
        items.add(new screen_letterenglish(R.drawable.necklace,R.drawable.n,R.raw.englishnecklace,"necklace" ));
        items.add(new screen_letterenglish(R.drawable.ostrich,R.drawable.o,R.raw.englishnaama,"Ostrich"));
        items.add(new screen_letterenglish(R.drawable.peacock,R.drawable.p,R.raw.englishpeacoke,"Peacock"));
        items.add(new screen_letterenglish(R.drawable.queen,R.drawable.q,R.raw.englishqueen,"queen"));
        items.add(new screen_letterenglish(R.drawable.rabbit,R.drawable.r,R.raw.englishrabbit,"rabbit"));
        items.add(new screen_letterenglish(R.drawable.sun,R.drawable.s,R.raw.englishsun,"Sun"));
        items.add(new screen_letterenglish(R.drawable.tiger,R.drawable.t,R.raw.englishtiger,"Tiger"));
        items.add(new screen_letterenglish(R.drawable.umbrella,R.drawable.u,R.raw.englishumbrella,"Umbrella"));
        items.add(new screen_letterenglish(R.drawable.vase2,R.drawable.v,R.raw.englishvase,"Vase"));
        items.add(new screen_letterenglish(R.drawable.wax,R.drawable.w,R.raw.englishwax,"Wax"));
        items.add(new screen_letterenglish(R.drawable.xylophone,R.drawable.x,R.raw.englishxylophone,"Xylophone"));
        items.add(new screen_letterenglish(R.drawable.yam,R.drawable.y,R.raw.englishyam,"Yam"));
        items.add(new screen_letterenglish(R.drawable.zebra,R.drawable.z,R.raw.englishzebra,"Zebra"));





        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new engletterAdapter(this, items);
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
