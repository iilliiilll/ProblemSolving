import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집의 수 n (2 <= n <= 1,000)
        int n = Integer.parseInt(br.readLine());

        int[][] colors = new int[n][3]; // 비용
        int[][] dp = new int[n][3]; // 최소 비용

        // 1 <= 비용 <= 1,000
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값
        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];

        // 배열 순회
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + colors[i][0];
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + colors[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + colors[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}