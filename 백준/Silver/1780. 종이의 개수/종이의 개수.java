import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] arr;

    static int result1 = 0;
    static int result2 = 0;
    static int result3 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기 n (1 <= n <= 3^7)
        int n = Integer.parseInt(br.readLine());

        // 행렬 입력
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // (0, 0)부터 나누기
        divide(0, 0, n);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    static void divide(int x, int y, int size) {
        if (isSquare(x, y, size)) {
            if (arr[x][y] == -1) {
                result1++;
            } else if (arr[x][y] == 0) {
                result2++;
            } else {
                result3++;
            }

            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(x + newSize * i, y + newSize * j, newSize);
            }
        }
    }

    static boolean isSquare(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}