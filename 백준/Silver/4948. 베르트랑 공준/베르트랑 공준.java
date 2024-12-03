import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n 입력 (1 <= n <= 123,456)
        int n;
        int result;

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            result = 0;

            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime(i)) {
                    result++;
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    // 소수 판단
    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}