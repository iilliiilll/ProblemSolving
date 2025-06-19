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
                if (Integer.parseInt(st.nextToken()) == 1) {
                    paper[i][j] = true;
                    blue += 1;
                } else {
                    paper[i][j] = false;
                    white += 1;
                }
            }
        }

        // 정사각형 크기 구하기
        for (int size = 2; size <= n; size *= 2) {
            for (int i = 0; i < n; i += size) {
                for (int j = 0; j < n; j += size) {
                    isSquare(size, i, j);
                }
            }
        }

        System.out.println(white);
        System.out.println(blue);
    }

    public static void isSquare(int size, int i, int j) {
        for (int row = i; row < i + size; row++) {
            for (int col = j; col < j + size; col++) {
                if (paper[i][j] != paper[row][col]) {
                    return;
                }
            }
        }

        if (paper[i][j]) { // 파란색 (true)
            blue -= 3;
        } else { // 하얀색 (false)
            white -= 3;
        }
    }
}