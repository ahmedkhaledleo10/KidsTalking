package com.Lithy.kidstalking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class EnglishActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialCardView mCardLettersEnglish;
    private MaterialCardView mCardNumbersEnglish;
    private MaterialCardView mCardColorsEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        mCardLettersEnglish = findViewById(R.id.card_LettersEnglish);
        mCardNumbersEnglish = findViewById(R.id.card_numbersEnglish);
        mCardColorsEnglish = findViewById(R.id.card_colorsEnglish);


        //add click listerner to cards
        mCardLettersEnglish.setOnClickListener(this);
        mCardNumbersEnglish.setOnClickListener(this);
        mCardColorsEnglish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i  ;
        switch (v.getId())
        {
            case R.id.card_LettersEnglish: i=new Intent(this,LettersEnglishActivity.class);
                startActivity(i);
                break;
            case R.id.card_numbersEnglish: i=new Intent(this,NumbersEnglishActivity.class);
                startActivity(i);
                break;
            case R.id.card_colorsEnglish: i=new Intent(this,ColorsEnglishActivity.class);
                startActivity(i);
                break;


            default:break;

        }
    }
}
