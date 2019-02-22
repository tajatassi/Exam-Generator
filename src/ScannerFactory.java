import java.util.Scanner;

public class ScannerFactory {
    private static Scanner s;

    private ScannerFactory() {
    }

    public static Scanner getScanner() {
        if (s == null) {
            s = new Scanner(System.in);
        }

        return s;
    }
}
