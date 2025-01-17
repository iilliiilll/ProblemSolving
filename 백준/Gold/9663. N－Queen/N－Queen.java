import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int n;
    static int result = 0;
    static boolean[] cols;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        n_queen(0);

        System.out.println(result);
    }

    // 행 기준으로 퀸 배치
    static void n_queen(int row) {
        if (row == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!cols[i] && !diag1[row - i + n - 1] && !diag2[row + i]) {
                cols[i] = true;
                diag1[row - i + n - 1] = true;
                diag2[row + i] = true;
                n_queen(row + 1);
                cols[i] = false;
                diag1[row - i + n - 1] = false;
                diag2[row + i] = false;
            }
        }
    }

}
