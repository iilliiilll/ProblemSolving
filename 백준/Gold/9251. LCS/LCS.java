import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch1 = br.readLine().toCharArray();
        char[] ch2 = br.readLine().toCharArray();

        int[][] dp = new int[ch1.length + 1][ch2.length + 1];

        for (int i = 1; i < ch1.length + 1; i++) {
            for (int j = 1; j < ch2.length + 1; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < ch1.length + 1; i++) {
            for (int j = 0; j < ch2.length + 1; j++) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max);
    }
}