import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int F = 1_000_000_007;
    static int[][] matrix = {
        {1, 1},
        {1, 0},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n번째 피보나치 수. 1 <= n <= 1,000,000,000,000,000,000
        long n = Long.parseLong(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(pow(matrix, n - 1)[0][0]);
    }

    public static int[][] pow(int[][] a, long n) {
        if (n == 1) {
            return a;
        }

        int[][] temp = pow(a, n / 2);
        temp = mul(temp, temp);

        if (n % 2 == 1) {
            temp = mul(temp, a);
        }

        return temp;
    }

    public static int[][] mul(int[][] a, int[][] b) {
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long temp = 0;

                for (int k = 0; k < 2; k++) {
                    temp = (temp + (long) a[i][k] * b[k][j]) % F;
                }

                c[i][j] = (int) temp;
            }
        }

        return c;
    }

}