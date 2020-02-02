package com.Lithy.kidstalking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class StoriesActivity extends AppCompatActivity implements View.OnClickListener{

    private MaterialCardView mCardArab1;
    private MaterialCardView mCardArab2;
    private MaterialCardView mCardEng1;
    private MaterialCardView mCardEng2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        mCardArab1 = findViewById(R.id.card_arab1);
        mCardArab2 = findViewById(R.id.card_arab2);
        mCardEng1 = findViewById(R.id.card_eng1);
        mCardEng2 = findViewById(R.id.card_eng2);



        //add click listerner to cards
        mCardArab1.setOnClickListener(this);
        mCardArab2.setOnClickListener(this);
        mCardEng1.setOnClickListener(this);
        mCardEng2.setOnClickListener(this);


        }

    @Override
    public void onClick(View v) {
        Intent i  ;
        switch (v.getId())
        {
            case R.id.card_arab1: i=new Intent(this,ArabStory1Activity.class);
                startActivity(i);
                break;
            case R.id.card_arab2: i=new Intent(this,ArabStory2Activity.class);
                startActivity(i);
                break;
            case R.id.card_eng1: i=new Intent(this,EnglishStory1Activity.class);
                startActivity(i);
                break;
            case R.id.card_eng2: i=new Intent(this,EnglishStory2Activity.class);
                startActivity(i);
                break;

            default:break;

        }
    }
}
