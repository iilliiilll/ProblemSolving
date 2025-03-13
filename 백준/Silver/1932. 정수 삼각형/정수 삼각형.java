import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 삼각형의 크기 n (1 <= n <= 500)
        int n = Integer.parseInt(br.readLine());

        // 배열 생성
        int[][] triangle = new int[n][n]; // 삼각형
        int[][] dp = new int[n][n]; // 경로합

        // 삼각형 채우기 (0 <= 정수 <= 9,999)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 맨 위층은 고정
        dp[0][0] = triangle[0][0];

        // 최대 경로합 구하기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) { // 맨 왼쪽
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) { // 맨 오른쪽
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else { // 중간
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (max < dp[n - 1][i]) {
                max = dp[n - 1][i];
            }
        }

        System.out.println(max);
    }
}