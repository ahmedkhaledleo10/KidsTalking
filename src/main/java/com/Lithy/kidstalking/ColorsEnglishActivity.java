package com.Lithy.kidstalking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Lithy.kidstalking.Adapter.englishcolorAdapter;
import com.Lithy.kidstalking.model.screen_englishcolor;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ColorsEnglishActivity extends AppCompatActivity {

    ViewPager mViewpagerstory;
    englishcolorAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_englishcolor> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_english);



        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);

        items = new ArrayList<>();
        items.add(new screen_englishcolor(R.drawable.roman,R.drawable.red,R.raw.englishred));
        items.add(new screen_englishcolor(R.drawable.grape,R.drawable.green,R.raw.englishgreen));
        items.add(new screen_englishcolor(R.drawable.yellow,R.drawable.yellow2,R.raw.englishyellow));
        items.add(new screen_englishcolor(R.drawable.orange,R.drawable.orange2,R.raw.englishorange));
        items.add(new screen_englishcolor(R.drawable.blue,R.drawable.blue2,R.raw.englishblue));
        items.add(new screen_englishcolor(R.drawable.black,R.drawable.black2,R.raw.englishblack));
        items.add(new screen_englishcolor(R.drawable.purple,R.drawable.purple2,R.raw.englishpurple));




        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new englishcolorAdapter(this, items);
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
