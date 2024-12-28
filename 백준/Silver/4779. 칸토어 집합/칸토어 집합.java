import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            int n = (int) Math.pow(3, Integer.parseInt(line));

            String s = "-".repeat(n);

            s = getCantor(s);
            System.out.println(s);
        }
    }

    static String getCantor(String s) {
        int n = s.length();

        if (n == 1) {
            return s;
        }

        int third = n / 3;
        String left = getCantor(s.substring(0, third));
        String middle = " ".repeat(third);
        String right = getCantor(s.substring(2 * third));

        return left + middle + right;
    }
}