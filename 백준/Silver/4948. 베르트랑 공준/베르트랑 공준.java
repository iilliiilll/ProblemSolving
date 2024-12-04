import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1 <= n <= 123,456
        int n;
        int max = 123456;
        boolean[] prime = new boolean[2 * max + 1];
        getPrime(prime);

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (prime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    // 에라토스테네스의 체
    static void getPrime(boolean[] prime) {
        // 초기화
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        // 소수가 아니면 false
        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i * i; j < prime.length; j += i)
                    prime[j] = false;
            }
        }
    }
}
