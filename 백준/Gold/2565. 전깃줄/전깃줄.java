import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        int[][] dp = new int[2][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // n == 1
        if (n == 1) {
            System.out.println(0);
            return;
        }

        // 2차원 배열 정렬
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        // arr 1열 -> dp 0행 대입
        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[i][1];
        }

        // dp에서 최장증가수열 길이 구하기
        dp[1][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[0][i] > dp[0][j] && dp[1][i] < dp[1][j]) {
                    dp[1][i] = dp[1][j];
                }
            }
            dp[1][i] += 1;
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (max < dp[1][i]) {
                max = dp[1][i];
            }
        }

        System.out.println(n - max);
    }
}