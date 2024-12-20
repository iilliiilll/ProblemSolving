import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());

        System.out.println(Fac(n));
    }

    static long Fac(long n) {
        if (n > 1) {
            return n * Fac(n - 1);
        } else {
            return 1;
        }

    }
}