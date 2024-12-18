import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 1 <= n <= 10
        // 0 <= k <= n
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(Fac(n) / (Fac(n - k) * Fac(k)));

    }

    static int Fac(int n) {
        if (n == 0) {
            return 1;
        } else {
            int sum = 1;
            for (int i = 1; i <= n; i++) {
                sum *= i;
            }

            return sum;
        }
    }
}