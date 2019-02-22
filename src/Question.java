import java.io.*;
import java.util.*;

public abstract class Question {

    protected String title;
    protected Answer rightAnswer;
    protected Answer studentAnswer;
    protected double maxValue;


    protected Question() {
        title = null;
        maxValue = 0;
        rightAnswer = null;
        studentAnswer = null;
    }

    protected Question(String s, double m) {
        title = s;
        maxValue = m;
        rightAnswer = null;
        studentAnswer = null;
    }

    protected Question(Scanner s) {

    }

    public abstract Answer getNewAnswer();

    public abstract void getAnswerFromStudent();

    public abstract double getValue();

    public void print() {
        System.out.println(title + "\n");
    }

    public String toString() {
        return title;
    }

    public void saveStudentAnswers(PrintWriter p) {
        studentAnswer.saveStudentAnswers(p);
    }

    public void setRightAnswer(Answer correct) {
        rightAnswer = correct;
    }

    public void save(PrintWriter p) {
        p.println(title);
    }


    public void restoreStudentAnswers(Scanner s) {
        //"Abstract" but not needed for ever class
    }
}
