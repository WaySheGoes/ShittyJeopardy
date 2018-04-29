package edu.oswego.jeopardy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {
	Question question = new Question();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
    	question = GetQuestion();
    	bindQuestion();
    }
    
    public ArrayList<Question> GetQuestion(){
        Intent intent = getIntent();
        Question q = intent.getParcelableArrayListExtra("questionInGame");
        return q;
    }

    private void bindQuestion(){
    	View question = findViewById(R.id.textView);
		View answerA = findViewById(R.id.A);
		View answerB = findViewById(R.id.B);
		View answerC = findViewById(R.id.C);
		View answerD = findViewById(R.id.D);

		question.setText = question.getQuestionText();
		answerA.setText = question.getAnswerA();
		answerB.setText = question.getAnswerB();
		answerC.setText = question.getAnswerC();
		answerD.setText = question.getAnswerD();
    }
}
