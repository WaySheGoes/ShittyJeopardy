package edu.oswego.questionparser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class QuestionParser{
    private ArrayList<Question> questionList = new ArrayList<>();
    private Question question = null;
    private final String URL;

    public QuestionParser(String inUrl) {
        this.URL = inUrl;
    }

    public ArrayList<Question> startParsing() {
        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            URL url = new URL(URL);
            URLConnection client = url.openConnection();
            InputStream in = client.getInputStream();

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);

            parseQuestions(parser);
            in.close();

        }catch (XmlPullParserException x){
            System.out.println("=====XmlPullParserException=====");
            System.out.println("========StackTraceStart========");
            x.printStackTrace();
            System.out.println("=========StackTraceEnd=========");
        }catch (MalformedURLException m){
            System.out.println("=====MalformedURLException=====");
            System.out.println("========StackTraceStart========");
            m.printStackTrace();
            System.out.println("=========StackTraceEnd=========");
        } catch (IOException e) {
            System.out.println("==========IOException==========");
            System.out.println("========StackTraceStart========");
            e.printStackTrace();
            System.out.println("=========StackTraceEnd=========");
        }
        return questionList;
    }

    private void parseQuestions(XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        while(eventType != XmlPullParser.END_DOCUMENT){
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    System.out.println("START DOCUMENT");
                    break;
                case XmlPullParser.START_TAG:
                    String tagName = parser.getName();
                    parser.next();
                    tagSwitch(parser, tagName);
                    break;
                case XmlPullParser.END_TAG:
                    break;
            }
            eventType = parser.next();
        }
        System.out.println("END DOCUMENT");
    }

    private void tagSwitch(XmlPullParser parser, String tagName) throws IOException, XmlPullParserException {
        switch (tagName){
            case "questions":
                System.out.println("We in.");
                break;
            case "question":
                question = new Question();
                System.out.println("Question Start");
                break;
            case "category":
                question.setCategory(parser.getText());
                break;
            case "value":
                question.setDollarValue(Integer.parseInt(parser.getText().replace("$", "")));
                break;
            case "text":
                question.setQuestionText(parser.getText());
                break;
            case "answerA":
                question.setAnswerA(parser.getText());
                break;
            case "answerB":
                question.setAnswerB(parser.getText());
                break;
            case "answerC":
                question.setAnswerC(parser.getText());
                break;
            case "answerD":
                question.setAnswerD(parser.getText());
                break;
            case "correctAnswer":
                question.setCorrectAnswer(parser.getText().charAt(0));
                questionList.add(question);
                System.out.println("Question Added");
                break;
        }
    }
}
