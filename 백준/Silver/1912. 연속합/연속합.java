import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1 <= n <= 100,000
        int n = Integer.parseInt(br.readLine());

        // 배열 : -1,000 < dp[i] < 1,000
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        // 최대합 구하기
        int num = dp[0];
        for (int i = 1; i < n; i++) {
            num = Math.max(dp[i], dp[i] + num);

            if (num > MAX) {
                MAX = num;
            }
        }

        System.out.println(Math.max(MAX, dp[0]));
    }
}