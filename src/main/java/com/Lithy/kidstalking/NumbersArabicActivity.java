package com.Lithy.kidstalking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Lithy.kidstalking.Adapter.arabicnumberAdapter;
import com.Lithy.kidstalking.model.screen_arabicnumber;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NumbersArabicActivity extends AppCompatActivity {

    ViewPager mViewpagerstory;
    arabicnumberAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_arabicnumber> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_arabic);

        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);

        items = new ArrayList<>();
        items.add(new screen_arabicnumber(R.drawable.one, R.drawable.wahed ,R.raw.arabicone,"واحد"));
        items.add(new screen_arabicnumber(R.drawable.two, R.drawable.atnen,R.raw.arabictwo,"اثنين"));
        items.add(new screen_arabicnumber(R.drawable.three, R.drawable.tlata, R.raw.arabicthree,"ثلاثه"));
        items.add(new screen_arabicnumber(R.drawable.four, R.drawable.arbaa,R.raw.arabicfour,"اربعه"));
        items.add(new screen_arabicnumber(R.drawable.five, R.drawable.khamsa,R.raw.arabicfive,"خمسه"));
        items.add(new screen_arabicnumber(R.drawable.six, R.drawable.sta,R.raw.arabicsix,"سته"));
        items.add(new screen_arabicnumber(R.drawable.seven, R.drawable.sbaa, R.raw.arabicseven,"سبعه"));
        items.add(new screen_arabicnumber(R.drawable.eight, R.drawable.thmania,R.raw.arabiceight,"ثمانيه"));
        items.add(new screen_arabicnumber(R.drawable.nine, R.drawable.tsaa,R.raw.arabicnine, "تسعه"));
        items.add(new screen_arabicnumber(R.drawable.ten, R.drawable.ashra, R.raw.arabicten,"عشره"));



        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new arabicnumberAdapter(this, items);
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
