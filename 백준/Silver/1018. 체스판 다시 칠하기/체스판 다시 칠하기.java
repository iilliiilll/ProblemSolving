import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 보드판 생성
        board = new char[n][m];

        // 입력받은 값으로 보드판 만들기
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 칠해야 하는 정사각형의 개수는 최대 64개
        int min = 64;

        // 8 x 8 크기의 정사각형으로 보드판 순회
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                min = Math.min(min, findMin(i, j));
            }
        }

        System.out.println(min);

        br.close();
    }

    public static int findMin(int i, int j) {

        int white = 0; // 왼쪽 맨 위 칸이 하얀색으로 시작하는 경우 -> 짝수 칸이 하얀색
        int black = 0; // 왼쪽 맨 위 칸이 검은색으로 시작하는 경우 -> 짝수 칸이 검은색

        // i, j부터 8칸만큼의 정사각형만큼 순회
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                // 현재 위치를 표시
                if ((a + b) % 2 == 0) {
                    if (board[a + i][b + j] == 'W') { // 현재 위치가 하얀색
                        black++;
                    } else { // 현재 위치가 검은색
                        white++;
                    }
                } else {
                    if (board[a + i][b + j] == 'W') {
                        white++;
                    } else {
                        black++;
                    }
                }
            }
        }

        return Math.min(white, black);
    }
}
