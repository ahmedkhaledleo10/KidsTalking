package com.Lithy.kidstalking;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private MaterialCardView mCardArabic;
    private MaterialCardView mCardEnglish;
    private MaterialCardView mCardQuiz;
    private MaterialCardView mCardGame;
    private MaterialCardView mCardStories;
    private MaterialCardView mCardExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //defining the cards
        mCardArabic = findViewById(R.id.card_arabic);
        mCardEnglish = findViewById(R.id.card_english);
        mCardQuiz = findViewById(R.id.card_quiz);
        mCardGame = findViewById(R.id.card_game);
        mCardStories = findViewById(R.id.card_stories);
        mCardExit = findViewById(R.id.card_exit);

        //add click listerner to cards
        mCardArabic.setOnClickListener(this);
        mCardEnglish.setOnClickListener(this);
        mCardQuiz.setOnClickListener(this);
        mCardGame.setOnClickListener(this);
        mCardStories.setOnClickListener(this);



        mCardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Confirm Exit...!!");
                builder.setIcon(R.drawable.ic_exit_to_app_black_24dp);
                builder.setMessage("Are You Sure You Want To exit");
                builder.setCancelable(false);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "you clicked on cancel", Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog  alertdialog=builder.create();
                alertdialog.show();
            }
        });


    }





    @Override
    public void onClick(View v) {

        Intent i  ;
        switch (v.getId())
        {
            case R.id.card_arabic: i=new Intent(this,ArabicActivity.class);
                startActivity(i);
                break;
            case R.id.card_english: i=new Intent(this,EnglishActivity.class);
                startActivity(i);
                break;
            case R.id.card_quiz: i=new Intent(this,StartingScreenQuizActivity.class);
                startActivity(i);
                break;
            case R.id.card_game: i=new Intent(this,GameActivity.class);
                startActivity(i);
                break;
            case R.id.card_stories: i=new Intent(this,StoriesActivity.class);
                startActivity(i);
                break;

                default:break;

        }



    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Confirm Exit...!!");
        builder.setIcon(R.drawable.ic_exit_to_app_black_24dp);
        builder.setMessage("Are You Sure You Want To exit");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you clicked on cancel", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog  alertdialog=builder.create();
        alertdialog.show();
    }


}

