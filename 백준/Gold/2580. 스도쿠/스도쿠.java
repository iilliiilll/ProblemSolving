import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 값 입력받기
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        // 종료 조건
        if (row == 9) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }

            System.out.println(sb);
            System.exit(0);
        }

        // 빈칸 채우기
        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }

            arr[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    public static boolean possibility(int row, int col, int value) {
        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) return false;
        }

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) return false;
        }

        // 3x3 칸 검사
        int first_row = (row / 3) * 3; // 3x3의 행의 첫 위치
        int first_col = (col / 3) * 3; // 3x3의 열의 첫 위치

        for (int i = first_row; i < first_row + 3; i++) {
            for (int j = first_col; j < first_col + 3; j++) {
                if(arr[i][j] == value) return false;
            }
        }

        return true;
    }
}