import java.io.*;
import java.util.*;

public abstract class Answer {

    protected Answer() {
    }

    protected Answer(Scanner s) {
    }

    public abstract void print();

    public abstract double getCredit(Answer a);

    public abstract void save(PrintWriter p);

    public abstract void saveStudentAnswers(PrintWriter p);
}
