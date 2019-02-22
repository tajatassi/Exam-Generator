import java.io.PrintWriter;
import java.util.Scanner;

public class SAAnswer extends Answer {

    private String title;

    public SAAnswer() {
    }

    public SAAnswer(String text) {
        title = text;
    }

    public SAAnswer(Scanner s) {
        title = s.nextLine();
    }

    @Override
    public void print() {
        System.out.println("\t" + title);
    }

    public String toString() {
        return "\t" + title;
    }

    @Override
    public double getCredit(Answer a) {
        if (title.equalsIgnoreCase(((SAAnswer) a).title)) {
            return 1.0;
        } else {
            return 0;
        }
    }

    @Override
    public void save(PrintWriter p) {
        StringBuilder sb = new StringBuilder(title);
        p.print(sb.toString());
    }

    @Override
    public void saveStudentAnswers(PrintWriter p) {
        save(p);
    }
}
