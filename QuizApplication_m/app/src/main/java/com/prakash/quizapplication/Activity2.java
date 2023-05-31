package com.prakash.quizapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

   TextView resultTextView;
   Button tryAgain,share;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        resultTextView = findViewById(R.id.resultTextView);
        tryAgain = findViewById(R.id.playAgain);
        share = findViewById(R.id.shareButton);
        Intent fetching = getIntent();
       int result = 20 * Integer.valueOf( fetching.getStringExtra("CorrectAnswersCount"));

       if(result >= 40) {
           resultTextView.setText(" Hurrah! Your Result is " + result + " Enjoy the day :)");
       }
       else if(result <40)
       {
           resultTextView.setText("Your Result is " + result + " No Problem \n A single Test Cannot Decide Your Future !  :)");
       }

       tryAgain.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent goToStart = new Intent(Activity2.this, MainActivity.class);
               startActivity(goToStart);
               finish();
           }
       });

       share.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent shareMsg = new Intent(Intent.ACTION_SEND);
               shareMsg.setType("text/plain");
               shareMsg.putExtra(Intent.EXTRA_SUBJECT,"Hey I have Scored "+result+" Points in Quiz game");
               shareMsg.putExtra(Intent.EXTRA_TEXT,"Checkout this New Quiz game named Quiz Shuru its  Interesting :)");

               startActivity(Intent.createChooser(shareMsg,"Choose one"));
           }
       });
    }
}
