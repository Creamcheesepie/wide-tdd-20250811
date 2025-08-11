import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtil {
    private static PrintStream originalOut;
    private static PrintStream currentOut;

    public static Scanner genScanner(String input) {
        return new Scanner(input);
    }


    public static ByteArrayOutputStream setOutToByteArray() {
        originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        currentOut = new PrintStream(outputStream);
        System.setOut(currentOut);

        return outputStream;
    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream outputStream) throws IOException {
        System.setOut(originalOut);
        currentOut.close();
    }

}
