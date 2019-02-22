import java.util.Scanner;

public class MCMAAnswer extends MCAnswer {
    protected MCMAAnswer() {
    }

    protected MCMAAnswer(String s, double valueIfSelected) {
        super(s, valueIfSelected);
    }

    protected MCMAAnswer(Scanner s) {
        super(s);
    }
}
