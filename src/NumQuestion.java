import java.io.*;
import java.util.*;

public class NumQuestion extends Question {

    private double tolerance;

    public NumQuestion(String title, double maxValue, double tolerance) {
        super(title, maxValue);
        this.tolerance = tolerance;
    }

    protected NumQuestion(Scanner s) {
        maxValue = Double.parseDouble(s.nextLine());
        title = s.nextLine();
        rightAnswer = new NumAnswer(Double.parseDouble(s.nextLine()));
        tolerance = Double.parseDouble(s.nextLine());
    }

    @Override
    public Answer getNewAnswer() {
        return new NumAnswer();
    }

    public Answer getNewAnswer(double value) {
        return new NumAnswer(value);
    }

    public String toString() {
        return super.toString() + "\n";
    }

    @Override
    public void getAnswerFromStudent() {
        Scanner input = ScannerFactory.getScanner();
        String temp = input.nextLine();
        double ans = Double.parseDouble(temp);

        studentAnswer = new NumAnswer(ans);
    }

    @Override
    public double getValue() {
        return ((NumAnswer) studentAnswer).getCredit(rightAnswer, tolerance) * maxValue;
    }

    public void save(PrintWriter p) {
        p.println(maxValue);
        p.println(title);
        rightAnswer.save(p);
        p.println(tolerance);
    }

    @Override
    public void saveStudentAnswers(PrintWriter p) {
        studentAnswer.save(p);
        p.println();
    }

    public void restoreStudentAnswers(Scanner s) {
        studentAnswer = new NumAnswer(s);
    }

    public void setAnswer(String a) {
        double ans = Double.parseDouble(a);

        studentAnswer = new NumAnswer(ans);

    }
}
