import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] a;
    static int[][] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // n, m, k <= 100, |원소| <= 100
        // 행렬 A
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 B
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        b = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬곱 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                sb.append(cal(i, j, m)).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static int cal(int row, int col, int size) {
        int temp = 0;

        for (int i = 0; i < size; i++) {
            temp += a[row][i] * b[i][col];
        }

        return temp;
    }

}