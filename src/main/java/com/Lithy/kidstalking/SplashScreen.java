package com.Lithy.kidstalking;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView mImgelephant;
    ImageView mImgkids;
    ImageView mImghello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mImgelephant = findViewById(R.id.imgelephant);
        mImgkids = findViewById(R.id.imgkids);
        mImghello = findViewById(R.id.imghello);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        mImgelephant.setAnimation(topAnim);
        mImghello.setAnimation(topAnim);
        mImgkids.setAnimation(bottomAnim);


        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashScreen.this, introActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 4000);

    }
}
