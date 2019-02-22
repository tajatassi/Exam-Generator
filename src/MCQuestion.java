import java.util.*;

public abstract class MCQuestion extends Question {

    protected ArrayList<Answer> answers;

    protected MCQuestion() {
    }

    protected MCQuestion(String s, double m) {
        super(s, m);
        answers = new ArrayList<>();
    }

    protected MCQuestion(Scanner s) {

    }

    public void addAnswer(Answer toAdd) {
        answers.add(toAdd);
    }

    public void reorderAnswers() {
        Collections.shuffle(answers);
    }

    protected String toAlphabet(int pos) {
        if (pos < 0)
            return toAlphabet(-pos - 1);

        int quotient = pos / 26;
        int remainder = pos % 26;
        char letter = (char) ((int) 'A' + remainder);
        if (quotient == 0) {
            return "" + letter;
        } else {
            return toAlphabet(quotient - 1) + letter;
        }
    }

    @Override
    public void print() {
        super.print();
        int i = 0;
        for (Answer a : answers) {
            System.out.print("\t" + toAlphabet(i++) + ". ");
            a.print();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        int i = 0;

        sb.append("\n");

        for (Answer a : answers) {
            sb.append("\t" + toAlphabet(i++) + ". ");
            sb.append(a.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public double getValue(Answer studentAnswer) {
        double accum = 0;

        for (Answer a : answers) {
            accum += studentAnswer.getCredit(a);
        }

        return accum;
    }
}
