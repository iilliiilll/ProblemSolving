import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1 <= m <= n <= 1,000,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 에라토스테세스의 체
        int max = 1_000_000;
        boolean[] prime = new boolean[max + 1];
        getPrime(prime);

        // 소수 찾기
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                sb.append(i).append('\n');
            }
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
