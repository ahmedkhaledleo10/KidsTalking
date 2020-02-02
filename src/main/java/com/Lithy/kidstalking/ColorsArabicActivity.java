package com.Lithy.kidstalking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Lithy.kidstalking.Adapter.arabiccolorAdapter;
import com.Lithy.kidstalking.model.screen_arabiccolor;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ColorsArabicActivity extends AppCompatActivity {

    ViewPager mViewpagerstory;
    arabiccolorAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_arabiccolor> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_arabic);

        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);

        items = new ArrayList<>();
        items.add(new screen_arabiccolor(R.drawable.roman,R.drawable.ahmar,R.raw.arabicred));
        items.add(new screen_arabiccolor(R.drawable.grape,R.drawable.akhdar,R.raw.arabicgreen));
        items.add(new screen_arabiccolor(R.drawable.purple,R.drawable.pnfsgy,R.raw.arabicpurple));
        items.add(new screen_arabiccolor(R.drawable.black,R.drawable.asod,R.raw.arabicblack));
        items.add(new screen_arabiccolor(R.drawable.blue,R.drawable.azrak,R.raw.arabicblue));
        items.add(new screen_arabiccolor(R.drawable.orange,R.drawable.bortany,R.raw.arabicorange));
        items.add(new screen_arabiccolor(R.drawable.yellow,R.drawable.asfar,R.raw.arabicyellow));



        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new arabiccolorAdapter(this, items);
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
