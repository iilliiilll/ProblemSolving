import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1 <= n <= 1,000
        int n = Integer.parseInt(br.readLine());

        // 배열 생성
        int[][] arr = new int[2][n];
        int[] dp = new int[n];

        // arr 0행: 수열 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }

        // arr 1행: 최장증가수열의 길이
        arr[1][0] = 1;

        if (n == 1) {
            System.out.println(arr[1][0]);
            return;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[0][j] < arr[0][i] && arr[1][i] < arr[1][j]) { // 현재 값이 더 클 때만 arr[1]의 최댓값 구하기
                        arr[1][i] = arr[1][j];
                }
            }

            arr[1][i] += 1;
        }

        // arr 1행에서 최댓값 구하기
        int max = -1;
        for (int i : arr[1]) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);
    }
}