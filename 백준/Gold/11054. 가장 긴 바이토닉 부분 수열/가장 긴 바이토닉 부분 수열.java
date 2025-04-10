import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[][] dp = new int[3][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // n == 1
        if (n == 1) {
            System.out.println(1);
            return;
        }

        // dp[0][]: 앞에서 증가
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[0][i] < dp[0][j]) {
                    dp[0][i] = dp[0][j];
                }
            }
            dp[0][i] += 1;
        }

        // dp[1][]: 뒤에서 증가
        dp[1][n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j] && dp[1][i] < dp[1][j]) {
                    dp[1][i] = dp[1][j];
                }
            }
            dp[1][i] += 1;
        }

        // dp[2][] = dp[0][] + dp[1][]
        for (int i = 0; i < n; i++) {
            dp[2][i] = dp[0][i] + dp[1][i];
        }

        // 출력
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (max < dp[2][i]) {
                max = dp[2][i];
            }
        }
        System.out.print(max - 1);
    }
}