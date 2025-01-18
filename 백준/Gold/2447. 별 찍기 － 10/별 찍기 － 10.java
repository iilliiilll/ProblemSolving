import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n = 3^k (1 <= k < 8)
        int n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        // 배열을 공백으로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = ' ';
            }
        }

        // 별 찍기
        drawStar(0, 0, n);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void drawStar(int x, int y, int size) {
        // 크기가 1인 경우
        if (size == 1) {
            map[x][y] = '*';
            return;
        }

        // 현재 정사각형을 행, 열 기준으로 3등분
        int div = size / 3;

        // 3x3 영역 중 8개는 재귀호출, 가운데는 공백 유지
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                drawStar(x + i * div, y + j * div, div);
            }
        }
    }


}
