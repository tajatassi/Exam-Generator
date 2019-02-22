import java.io.*;
import java.util.*;

public class MCAnswer extends Answer {

    protected String title;
    protected boolean selected;
    protected double credit;

    protected MCAnswer() {
    }

    protected MCAnswer(String s, double valueIfSelected) {
        title = s;
        selected = false;
        credit = valueIfSelected;
    }

    protected MCAnswer(Scanner s) {
        credit = s.nextDouble();
        title = s.nextLine();
        if (title.startsWith(" ")) {
            title = title.substring(1);
        }
    }

    @Override
    public void print() {
        System.out.println(title);
    }

    public String toString() {
        return title;
    }

    @Override
    public double getCredit(Answer a) {
        if (title.equalsIgnoreCase(((MCAnswer) a).title)) {
            return credit;
        } else {
            return 0;
        }
    }

    @Override
    public void save(PrintWriter p) {
        StringBuilder sb = new StringBuilder();

        sb.append(credit);
        sb.append(" ");
        sb.append(title);

        p.println(sb.toString());
    }

    @Override
    public void saveStudentAnswers(PrintWriter p) {
        save(p);
    }
}
