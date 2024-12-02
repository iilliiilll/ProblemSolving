import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 자연수 m, n (1 <= m <= n <= 1,000,000)
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 소수 구하기
        while (m <= n) {
            if (isPrime(m)) {
                sb.append(m).append('\n');
            }

            m++;
        }

        System.out.println(sb);

        br.close();
    }

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