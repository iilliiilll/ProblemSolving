import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    // 1 <= n <= 100
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            if (dp[n] == 0) {
                fn(n);
            }

            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }

    static long fn(int n) {
        if (dp[n - 1] == 0) {
            fn(n - 1);
        }
        if (dp[n - 5] == 0) {
            fn(n - 5);
        }

        dp[n] = dp[n - 1] + dp[n - 5];
        return dp[n];
    }
}