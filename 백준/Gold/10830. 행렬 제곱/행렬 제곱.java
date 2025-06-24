import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 2 <= n <= 5, 1 <= b <= 100,000,000,000
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] a = new int[n][n];

        // 0 <= 원소 <= 1,000
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        // 행렬 a를 b제곱
        int[][] result = pow(a, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static int[][] pow(int[][] a, long b) {
        if (b == 1) {
            return a;
        }

        int[][] temp = pow(a, b / 2);
        int[][] matrix = multiply(temp, temp);

        if (b % 2 == 1) {
            matrix = multiply(matrix, a);
        }

        return matrix;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = cal(a, b, i, j);
            }
        }

        return temp;
    }

    public static int cal(int[][] a, int[][] b, int row, int col) {
        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp += a[row][i] * b[i][col];
        }

        return temp % 1000;
    }

}