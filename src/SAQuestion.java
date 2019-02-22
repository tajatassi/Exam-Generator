import java.io.*;
import java.util.*;

public class SAQuestion extends Question {

    protected SAQuestion(String s, double m) {
        super(s, m);
    }

    protected SAQuestion(Scanner s) {
        maxValue = Double.parseDouble(s.nextLine());
        title = s.nextLine();
        rightAnswer = new SAAnswer(s);
    }

    @Override
    public Answer getNewAnswer() {
        return new SAAnswer();
    }

    public Answer getNewAnswer(String text) {
        return new SAAnswer(text);
    }

    @Override
    public void getAnswerFromStudent() {
        Scanner input = ScannerFactory.getScanner();
        studentAnswer = new SAAnswer(input.nextLine());
    }

    public String toString() {
        return super.toString() + "\n";
    }

    @Override
    public double getValue() {
        if (studentAnswer == null)
            return 0;
        else
            return studentAnswer.getCredit(rightAnswer) * maxValue;
    }

    public void save(PrintWriter p) {
        p.println(maxValue);
        p.println(title);
        rightAnswer.save(p);
    }

    public void saveStudentAnswers(PrintWriter p) {
        studentAnswer.save(p);
        p.println();
    }

    public void restoreStudentAnswers(Scanner s) {
        studentAnswer = new SAAnswer(s);
    }

    public void setAnswer(String a) {
        studentAnswer = new SAAnswer(a);
    }


}
