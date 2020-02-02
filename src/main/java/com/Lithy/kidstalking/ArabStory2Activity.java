package com.Lithy.kidstalking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Lithy.kidstalking.Adapter.arabfoxstoryAdapter;
import com.Lithy.kidstalking.model.screen_arab2;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ArabStory2Activity extends AppCompatActivity {


    ViewPager mViewpagerstory;
    arabfoxstoryAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_arab2> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arab_story2);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);


        items = new ArrayList<>();
        items.add(new screen_arab2(R.drawable.pagearbic1));
        items.add(new screen_arab2(R.drawable.pagearbic2));
        items.add(new screen_arab2(R.drawable.pagearbic3));
        items.add(new screen_arab2(R.drawable.pagearbic4));
        items.add(new screen_arab2(R.drawable.pagearbic5));
        items.add(new screen_arab2(R.drawable.pagearbic6));
        items.add(new screen_arab2(R.drawable.pagearbic7));
        items.add(new screen_arab2(R.drawable.pagearbic8));
        items.add(new screen_arab2(R.drawable.pagearbic9));
        items.add(new screen_arab2(R.drawable.pagearbic10));
        items.add(new screen_arab2(R.drawable.pagearbic11));
        items.add(new screen_arab2(R.drawable.pagearbic12));
        items.add(new screen_arab2(R.drawable.pagearbic13));


        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new arabfoxstoryAdapter(this, items);
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
