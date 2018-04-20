package edu.oswego.questionparser;

public class Question {
    private String category;
    private int dollarValue;
    private String questionText;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private char correctAnswer;

    public Question(){

    }

    public Question(String cat, int val, String text, String a, String b,
                    String c, String d, char answer){
        this.category = cat;
        this.dollarValue = val;
        this.questionText = text;
        this.answerA = a;
        this.answerB = b;
        this.answerC = c;
        this.answerD = d;
        this.correctAnswer = answer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDollarValue(int inValue) {
        this.dollarValue = inValue;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public void setCorrectAnswer(char correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCategory() {
        return category;
    }

    public int getDollarValue() {
        return dollarValue;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}