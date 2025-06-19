import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static char[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 영상의 크기 n (2, 4, 8, 16, 32, 64)
        int n = Integer.parseInt(br.readLine());

        // 문자열 (0 or 1)
        video = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            video[i] = line.toCharArray();
        }

        divide(0, 0, n);

        System.out.println(sb);
    }

    static public void divide(int x, int y, int size) {

        if (isEqual(x, y, size)) {
            sb.append(video[x][y]);

            return;
        }

        int newSize = size / 2;

        sb.append("(");
        divide(x, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y, newSize);
        divide(x + newSize, y + newSize, newSize);
        sb.append(")");

    }

    static public boolean isEqual(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[x][y] != video[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}