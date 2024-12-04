import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());

        // 소수 판별 (에라토스테네스의 체)
        int max = 1_000_000;
        boolean[] prime = new boolean[max + 1];
        getPrime(prime, max);

        // 골드바흐 파티션
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(countGold(prime, n)).append('\n');
        }

        System.out.println(sb);
    }

    // 에라토스테네스의 체로 소수 구하기
    private static void getPrime(boolean[] prime, int max) {
        // 초기화
        for (int i = 2; i <= max; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    // 개수 세기
    private static int countGold(boolean[] prime, int n) {
        int count = 0;

        // 두 소수의 합이 n
        for (int i = 2; i <= n / 2; i++) {
            if (prime[i] && prime[n - i]) {
                count++;
            }
        }

        return count;
    }
}
