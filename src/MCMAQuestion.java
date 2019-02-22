import java.util.*;
import java.io.*;

public class MCMAQuestion extends MCQuestion {

    private double credit;
    private ArrayList<Answer> studentAnswer;

    public MCMAQuestion(String text, double maxValue, double baseCredit) {
        super(text, maxValue);
        credit = baseCredit;
        studentAnswer = new ArrayList<>();
    }

    protected MCMAQuestion(Scanner s) {
        answers = new ArrayList<>();
        studentAnswer = new ArrayList<>();

        maxValue = Double.parseDouble(s.nextLine());
        title = s.nextLine();
        credit = Double.parseDouble(s.nextLine());

        int i = Integer.parseInt(s.nextLine());

        for (int j = 0; j < i; j++) {
            super.addAnswer(new MCMAAnswer(s));
        }
    }

    @Override
    public Answer getNewAnswer() {
        return new MCMAAnswer();
    }

    public Answer getNewAnswer(String text, double value) {
        return new MCMAAnswer(text, value);
    }

    @Override
    public void getAnswerFromStudent() {
        Scanner input = ScannerFactory.getScanner();
        String temp = input.nextLine();
        String[] ans = temp.split(" ");

        for (String s : ans) {
            s = s.toUpperCase();
            studentAnswer.add((MCMAAnswer) answers.get((char) (s.charAt(0)) - 65));
        }
    }

    @Override
    public double getValue() {
        double accum = 0;

        for (Answer a : studentAnswer) {
            accum += super.getValue(a);
        }
        return (accum + credit) * maxValue;
    }

    @Override
    public void save(PrintWriter p) {
        p.println(maxValue);
        p.println(title);
        p.println(credit);
        p.println(answers.size());
        for (Answer a : answers) {
            a.save(p);
        }
    }

    public void saveStudentAnswers(PrintWriter p) {
        p.println(studentAnswer.size());
        for (Answer a : studentAnswer) {
            a.saveStudentAnswers(p);
        }
    }

    public void restoreStudentAnswers(Scanner s) {
        int i = Integer.parseInt(s.nextLine());
        for (int j = 0; j < i; j++) {
            studentAnswer.add(new MCMAAnswer(s));
        }
    }

    public void changeAnswer(String a) {
        studentAnswer.clear();
        String[] ans;
        ans = a.split(" ");

        for (String s : ans) {
            s = s.toUpperCase();
            studentAnswer.add((MCMAAnswer) answers.get((char) (s.charAt(0)) - 65));
        }
    }

    public void setAnswer(String a) {
        String[] ans;
        ans = a.split(" ");

        for (String s : ans) {
            s = s.toUpperCase();
            studentAnswer.add((MCMAAnswer) answers.get((char) (s.charAt(0)) - 65));
        }

    }

}
