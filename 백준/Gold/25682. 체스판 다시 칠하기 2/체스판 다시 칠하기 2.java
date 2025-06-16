import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 1 <= n, m <= 2,000
        //  1 <= k <= min(n, m)
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 배열 생성
        char[][] board = new char[n][m];

        // B, W 입력받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 변경할 횟수
        int[][] diffB = new int[n][m];
        int[][] diffW = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';

                if (board[i][j] != expectedB) {
                    diffB[i][j] = 1;
                }

                if (board[i][j] != expectedW) {
                    diffW[i][j] = 1;
                }
            }
        }

        // 누적합 배열
        int[][] prefixB = new int[n + 1][m + 1];
        int[][] prefixW = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixB[i][j] =
                    prefixB[i - 1][j] + prefixB[i][j - 1] -
                        prefixB[i - 1][j - 1] + diffB[i - 1][j - 1];

                prefixW[i][j] =
                    prefixW[i - 1][j] + prefixW[i][j - 1] -
                        prefixW[i - 1][j - 1] + diffW[i - 1][j - 1];

            }
        }

        // 최솟값 구하기 - k x k
        int min = Integer.MAX_VALUE;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int sumB =
                    prefixB[i][j] - prefixB[i - k][j] - prefixB[i][j - k] + prefixB[i - k][j - k];

                int sumW =
                    prefixW[i][j] - prefixW[i - k][j] - prefixW[i][j - k] + prefixW[i - k][j - k];

                min = Math.min(min, Math.min(sumB, sumW));
            }
        }

        // 결과
        System.out.println(min);
    }
}