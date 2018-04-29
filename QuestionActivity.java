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

    private bindQuestion(int buttonCat,  int Num){
    	int index = 0;
    	switch(buttonCat){
    		case 0: 
    		break;
    		case 1: index = 5;
    		break;
    		case 2: index = 11;
    		break;
    		case 3: index = 17;
    		break;
    		case 4: index = 23;
    		break;
    	}

    	index += Num;
    	//Retrieve Question at index Num and assign text to buttons
}
