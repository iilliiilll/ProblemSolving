import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int m, sum;
        boolean b = false;

        for (int i = n - 1; i > 0; i--) {
            m = n - i;
            sum = 0;

            String str = m + "";
            char[] arr = str.toCharArray();

            for (char c : arr) {
                sum += (c - '0');
            }

            if (m + sum == n) {
                System.out.println(m);
                b = true;
                break;
            }
        }

        if (!b) {
            System.out.println(0);
        }

        br.close();
    }
}