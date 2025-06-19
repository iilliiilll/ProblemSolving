import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static boolean[][] paper;
    static int white = 0; // 0 = 하얀색 = false
    static int blue = 0; // 1 = 파란색 = true

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 한 변의 길이 n (n = 2, 4, 8, 16, 32, 64, 128)
        int n = Integer.parseInt(br.readLine());

        // 색종이 색
        paper = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        divide(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (paper[x][y]) {
                blue++;
            } else {
                white++;
            }

            return;
        }

        int newSize = size / 2;

        divide(x, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y, newSize);
        divide(x + newSize, y + newSize, newSize);
    }

    public static boolean isSameColor(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != paper[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }
}