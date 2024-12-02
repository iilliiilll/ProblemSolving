import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스
        int t = Integer.parseInt(br.readLine());

        // 정수 n (0 <= n <= 4 * 10^9)
        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());

            while (true) {
                if (isPrime(n)) {
                    sb.append(n).append("\n");
                    break;
                }

                n++;
            }
        }

        System.out.println(sb);

        br.close();
    }

    static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}