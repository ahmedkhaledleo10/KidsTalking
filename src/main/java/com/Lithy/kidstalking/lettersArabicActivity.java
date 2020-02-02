package com.Lithy.kidstalking;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.Lithy.kidstalking.Adapter.arabletterAdapter;
import com.Lithy.kidstalking.model.screen_letterarab;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class lettersArabicActivity extends AppCompatActivity {


    ViewPager mViewpagerstory;
    arabletterAdapter adapter;
    int position = 0;
    ImageView imgnext;
    ImageView imgback;
    TabLayout TabIndicator;
    List<screen_letterarab> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_arabic);

        imgnext = findViewById(R.id.imgnext);
        imgback = findViewById(R.id.imgback);
        TabIndicator = findViewById(R.id.Tab_indicator);

        items = new ArrayList<>();
        items.add(new screen_letterarab(R.drawable.rabbit,R.drawable.alf,R.raw.arabicrabbit,"أرنب"));
        items.add(new screen_letterarab(R.drawable.cow,R.drawable.baa,R.raw.arabiccow,"بقره"));
        items.add(new screen_letterarab(R.drawable.crocodile,R.drawable.taa,R.raw.arabiccrocodile,"تمساح"));
        items.add(new screen_letterarab(R.drawable.snack,R.drawable.thaa,R.raw.arabicsnack,"ثعبان"));
        items.add(new screen_letterarab(R.drawable.camal,R.drawable.gem,R.raw.arabiccamal,"جمل"));
        items.add(new screen_letterarab(R.drawable.horse,R.drawable.haa,R.raw.arabichorse,"حصان"));
        items.add(new screen_letterarab(R.drawable.sheep,R.drawable.khaa,R.raw.arabicsheep,"خروف"));
        items.add(new screen_letterarab(R.drawable.chicken,R.drawable.dal,R.raw.arabicchicken,"دجاجه"));
        items.add(new screen_letterarab(R.drawable.corn,R.drawable.zal,R.raw.arabiccorn,"ذره"));
        items.add(new screen_letterarab(R.drawable.roman,R.drawable.raa,R.raw.arabicroman,"رمان"));
        items.add(new screen_letterarab(R.drawable.giraffe,R.drawable.zen,R.raw.arabicgiraffe,"زرافه"));
        items.add(new screen_letterarab(R.drawable.fish,R.drawable.seen,R.raw.arabicfish,"سمكه"));
        items.add(new screen_letterarab(R.drawable.sun,R.drawable.sheen,R.raw.arabicsun,"شمس"));
        items.add(new screen_letterarab(R.drawable.rocket,R.drawable.sad,R.raw.arabicrocket,"صاروخ"));
        items.add(new screen_letterarab(R.drawable.frog,R.drawable.dad,R.raw.arabicfrog,"ضفدع"));
        items.add(new screen_letterarab(R.drawable.peacock,R.drawable.tah,R.raw.arabicpeacoke,"طاووس"));
        items.add(new screen_letterarab(R.drawable.deer1,R.drawable.zah,R.raw.arabiczaby,"ظبي"));
        items.add(new screen_letterarab(R.drawable.grape,R.drawable.aain,R.raw.arabicgrape,"عنب"));
        items.add(new screen_letterarab(R.drawable.deer,R.drawable.khin,R.raw.arabicdeer,"غزاله"));
        items.add(new screen_letterarab(R.drawable.elephant,R.drawable.feh,R.raw.arabicelephant,"فيل"));
        items.add(new screen_letterarab(R.drawable.pencil,R.drawable.kaf,R.raw.arabicpencil,"قلم رصاص"));
        items.add(new screen_letterarab(R.drawable.dog,R.drawable.caf,R.raw.arabicdog,"كلب"));
        items.add(new screen_letterarab(R.drawable.lemon,R.drawable.lam,R.raw.arabiclemon,"ليمون"));
        items.add(new screen_letterarab(R.drawable.banana,R.drawable.mim,R.raw.arabicbanana,"موز"));
        items.add(new screen_letterarab(R.drawable.ostrich,R.drawable.noon,R.raw.arabicnaama,"نعامه"));
        items.add(new screen_letterarab(R.drawable.moon,R.drawable.heh,R.raw.arabicmoon,"هلال"));
        items.add(new screen_letterarab(R.drawable.boy,R.drawable.wow,R.raw.arabicboy,"ولد"));
        items.add(new screen_letterarab(R.drawable.hand,R.drawable.yaa,R.raw.arabichand,"يد"));







        mViewpagerstory = findViewById(R.id.viewpagerstory);
        adapter = new arabletterAdapter(this, items);
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
