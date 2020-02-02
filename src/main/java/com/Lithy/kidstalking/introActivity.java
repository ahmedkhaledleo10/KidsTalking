package com.Lithy.kidstalking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.Lithy.kidstalking.Adapter.introViewPagerAdapter;
import com.Lithy.kidstalking.model.screenItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class introActivity extends AppCompatActivity {

    ViewPager ScreenPager;
    introViewPagerAdapter adapter;
    TabLayout Tabindicator;
    Button mBtnnext;
    int position = 0;
    Button BtnStart;
    Button btn_skip;
    Animation btnAnimation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (RestorePereferenceData())

        {
            Intent mainactivity=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainactivity);
            finish();
        }


        setContentView(R.layout.activity_intro);


        //hide the actionbar

        //init views
        mBtnnext = findViewById(R.id.btnnext);
        BtnStart = findViewById(R.id.btnStart);
        Tabindicator = findViewById(R.id.Tab_indicator);
        btnAnimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        btn_skip = findViewById(R.id.btnskip);



        //fill list screen
        final List<screenItem> items = new ArrayList<>();
        items.add(new screenItem("(A)", "APPLE", R.drawable.apple));
        items.add(new screenItem("(B)", "BANANA", R.drawable.banana));
        items.add(new screenItem("(C)", "CAT", R.drawable.cat));


        //setupviewpager
        ScreenPager = findViewById(R.id.view_pager);
        adapter = new introViewPagerAdapter(this, items);
        ScreenPager.setAdapter(adapter);

        //setup tablayout with viewpager
        Tabindicator.setupWithViewPager(ScreenPager);

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main);
                finish();
            }
        });

        //next button click listener
        mBtnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = ScreenPager.getCurrentItem();
                if (position < items.size())

                    position++;
                ScreenPager.setCurrentItem(position);


                //when we click the last screen
                if (position == items.size()-1) {
                    //TODO:SHOW THE GETSTARTED BUTTON AND HIDE THE INDICATOR and next button

                    LoadLastScreen();

                }
            }
        });

        //tablayout add change listener
        Tabindicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition()==items.size()-1)
                {
                    LoadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainactivity=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainactivity);

                SavePereferenceData();
                finish();
            }
        });


    }

    private boolean RestorePereferenceData() {

        SharedPreferences preferences=getApplicationContext().getSharedPreferences("mypreference",MODE_PRIVATE);
        Boolean isIntroOpenedBefore=preferences.getBoolean("isIntroOpened",false);
        return isIntroOpenedBefore;



    }

    private void SavePereferenceData() {

        SharedPreferences preferences=getApplicationContext().getSharedPreferences("mypreference",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();

    }



    //SHOW THE GETSTARTED BUTTON AND HIDE THE INDICATOR and next button
    private void LoadLastScreen() {


        mBtnnext.setVisibility(View.INVISIBLE);
        Tabindicator.setVisibility(View.INVISIBLE);
        BtnStart.setVisibility(View.VISIBLE);

        //TODO:ADD THE ANIMATION FOR BUTTON GETSTARTED
        //setup button animation

        BtnStart.setAnimation(btnAnimation);


    }
}
