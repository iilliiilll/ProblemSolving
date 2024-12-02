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

            if (n <= 2) {
                sb.append(2).append('\n');
            } else if (n == 3) {
                sb.append(3).append('\n');
            } else {
                long temp = n % 2 == 0 ? n + 1 : n;

                while (true) {
                    if (isPrime(temp)) {
                        sb.append(temp).append("\n");
                        break;
                    }

                    temp += 2;
                }
            }

        }

        System.out.println(sb);

        br.close();
    }

    static boolean isPrime(long temp) {
        for (int i = 2; i <= Math.sqrt(temp); i++) {
            if (temp % i == 0) {
                return false;
            }
        }

        return true;
    }
}