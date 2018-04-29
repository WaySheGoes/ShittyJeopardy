package edu.oswego.jeopardy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
    
    }
    
    public ArrayList<Question> GetQestions(){
        Intent intent = getIntent();
        ArrayList<Question> q = intent.getParcelableArrayListExtra("questionsInGame");
        return q;
    }
}
