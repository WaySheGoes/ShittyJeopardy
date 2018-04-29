package edu.oswego.jeopardy;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questionlist = new ArrayList<>();
    private ArrayList<String> categories = new ArrayList<>();
    private final String XMLURL = "http://cs.oswego.edu/~awalts2/questions.xml";

    private final ArrayList<Question> questionsIngame = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadData();

    }
    public void LoadData(){
        new Thread() {
            @Override
            public void run() {
                QuestionParser questionparser = new QuestionParser(XMLURL);
                questionlist = questionparser.startParsing();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    SetInit();
                    }
                });
            }

        }.start();
    }

    public void SetQuestions(ArrayList<String> categories){
        for(int i =0; i<5;i++) {
            if (questionlist.get(i).getCategory() == categories.get(i)) {
                questionsIngame.add(questionlist.get(i));
            }
        }
    }

    public ArrayList<String> GetCategories(){
        Random r = new Random();
        ArrayList<String> categories = new ArrayList<>();
        int size = questionlist.size()-1;
        boolean used = false;

        while(categories.size() != 5){
            String category = questionlist.get(r.nextInt(size)).getCategory();
            for(String s : categories){
                if(s == category){
                    used = true;
                }
            }
            if(used == false){
                categories.add(category);
            }
            used = false;
        }
        return categories;
    }

     public void SetInit(){
         categories = GetCategories();
         SetQuestions(categories);
         setContentView(R.layout.activity_main);
         TextView tv1 = (TextView)findViewById(R.id.tv1);
          tv1.setText(categories.get(0));
         TextView tv2 = (TextView)findViewById(R.id.tv2);
         tv2.setText(categories.get(1));
         TextView tv3 = (TextView)findViewById(R.id.tv3);
         tv3.setText(categories.get(2));
         TextView tv4 = (TextView)findViewById(R.id.tv4);
         tv4.setText(categories.get(3));
         TextView tv5 = (TextView)findViewById(R.id.tv5);
         tv5.setText(categories.get(4));
     }



    public void goToQuestion(View view){
         
        Intent intent = new Intent(this, QuestionActivity.class);
        view.getContentDescription();
        intent.putExtra("questionsInGame",questionsIngame);
        startActivity(intent);
        Toast.makeText(this, "", Toast.LENGTH_LONG).show();
    }
}
