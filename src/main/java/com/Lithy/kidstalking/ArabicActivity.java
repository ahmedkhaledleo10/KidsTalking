package com.Lithy.kidstalking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class ArabicActivity extends AppCompatActivity implements View.OnClickListener{


    private MaterialCardView mCardLetters;
    private MaterialCardView mCardNumbers;
    private MaterialCardView mCardColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic);


        mCardLetters = findViewById(R.id.card_letters);
        mCardNumbers = findViewById(R.id.card_numbers);
        mCardColors = findViewById(R.id.card_colors);


        //add click listerner to cards
        mCardLetters.setOnClickListener(this);
        mCardNumbers.setOnClickListener(this);
        mCardColors.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i  ;
        switch (v.getId())
        {
            case R.id.card_letters: i=new Intent(this,lettersArabicActivity.class);
                startActivity(i);
                break;
            case R.id.card_numbers: i=new Intent(this,NumbersArabicActivity.class);
                startActivity(i);
                break;
            case R.id.card_colors: i=new Intent(this,ColorsArabicActivity.class);
                startActivity(i);
                break;


            default:break;

        }

    }
}
