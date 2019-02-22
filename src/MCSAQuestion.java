import java.util.*;
import java.io.*;

public class MCSAQuestion extends MCQuestion {

    public MCSAQuestion(String s, double m) {
        super(s, m);
    }

    public MCSAQuestion(Scanner s) {
        answers = new ArrayList<>();

        maxValue = Double.parseDouble(s.nextLine());
        title = s.nextLine();
        int i = Integer.parseInt(s.nextLine());

        for (int j = 0; j < i; j++) {
            super.addAnswer(new MCSAAnswer(s));
        }
    }

    @Override
    public Answer getNewAnswer() {
        return new MCSAAnswer();
    }

    public Answer getNewAnswer(String t, double v) {
        return new MCSAAnswer(t, v);
    }

    @Override
    public void getAnswerFromStudent() {
        Scanner input = ScannerFactory.getScanner();
        String ans = input.nextLine();
        ans = ans.toUpperCase();
        char c = ans.charAt(0);

        MCSAAnswer temp = (MCSAAnswer) answers.get((int) (c - 65));
        studentAnswer = temp;
    }

    @Override
    public double getValue() {
        if (studentAnswer != null)
            return super.getValue(studentAnswer) * maxValue;
        else
            return 0;
    }

    @Override
    public void save(PrintWriter p) {
        p.println(maxValue);
        p.println(title);
        p.println(answers.size());

        for (Answer a : answers) {
            a.save(p);
        }
    }

    @Override
    public void saveStudentAnswers(PrintWriter p) {
        studentAnswer.saveStudentAnswers(p);
    }

    @Override
    public void restoreStudentAnswers(Scanner s) {
        studentAnswer = new MCSAAnswer(s);
    }

    public void setAnswer(String a) {
        a = a.toUpperCase();
        char c = a.charAt(0);

        MCSAAnswer temp = (MCSAAnswer) answers.get((int) (c - 65));
        studentAnswer = temp;
    }
}
