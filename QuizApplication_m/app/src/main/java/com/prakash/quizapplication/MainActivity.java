package com.prakash.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView questionBox;
    int correctAnsCount = 0;
    int currentQuestionIndex = 0;
    String questions[] = {"Who is going to be the next Chief Minister?","Macintosh belongs to which company?","Who Owns jaguar Brand Currently?","Which Operating system amongst the following is considered as Hackers paradise?","Where is NECG Located?"};
    String solutions[] = {"Cannot be predicted","Apple","Tata","Kali Linux","Gudur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionBox = findViewById(R.id.questions_textView);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        displayQuestion(currentQuestionIndex);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    validateAnswer(b1.getText().toString());
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    validateAnswer(b2.getText().toString());
                }
            });


            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validateAnswer(b3.getText().toString());
                }
            });

            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validateAnswer(b4.getText().toString());
                }
            });

         }

         private void displayQuestion(int i)
         {
             questionBox.setText(questions[i]);
             if(i == 0)
             {
                 b1.setText("NOTA");
                 b2.setText("Cannot be predicted");
                 b3.setText("YSRCP");
                 b4.setText("Telugu Desam Party ");
             }
             else if(i == 1)
             {
                 b1.setText("Mac");
                 b2.setText("Microsoft");
                 b3.setText("Google");
                 b4.setText("Apple");
             }
             else if(i == 2)
             {
                 b1.setText("Tata");
                 b2.setText("Rolls Royce");
                 b3.setText("Ferrari");
                 b4.setText("VolksWagen");
             }
             else if(i==3)
             {
                 b1.setText("Ubuntu");
                 b2.setText("Red Hat");
                 b3.setText("Kali Linux");
                 b4.setText("Mint");
             }
             else if(i == 4)
             {
                 b1.setText("Guntur");
                 b2.setText("Bangalore");
                 b3.setText("Gudur");
                 b4.setText("Nellore");
             }
         }
         private void validateAnswer(String expectedSolution)
         {
             if(expectedSolution.equals(solutions[currentQuestionIndex]))
             {
                 correctAnsCount++;
             }
             currentQuestionIndex++;
             if(currentQuestionIndex<questions.length)
             {
                 displayQuestion(currentQuestionIndex);
             }
             else
             {
                 Toast.makeText(this, "Ur correct Answers are "+correctAnsCount , Toast.LENGTH_LONG).show();

                 try {
                     Thread.sleep(100);
                 }
                 catch (Exception e)
                 {

                 }
                 Intent nextpage = new Intent(MainActivity.this,Activity2.class);
                 nextpage.putExtra("CorrectAnswersCount",""+correctAnsCount);

                 startActivity(nextpage);
             }
         }


}