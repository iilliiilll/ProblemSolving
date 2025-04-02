import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= n <= 10,000
        int n = Integer.parseInt(br.readLine());

        // 배열 생성
        int[] grape = new int[n + 1];
        int[] sum = new int[n + 1];

        // 포도주의 양 (1,000 이하의 음이 아닌 정수)
        for (int i = 1; i <= n; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 대입
        sum[1] = grape[1];

        if (n > 1) {
            sum[2] = grape[1] + grape[2];

            if (n > 2) {
                for (int i = 3; i <= n; i++) {
                    // i번째 잔을 먹었을 때와 안먹었을 때를 비교해서 큰 값 선택
                    sum[i] = Math.max(grape[i] + Math.max(sum[i - 2], grape[i - 1] + sum[i - 3]), sum[i - 1]);
                }

                System.out.println(sum[n]);
            } else {
                System.out.println(sum[2]);
            }
        } else {
            System.out.println(sum[1]);
        }
    }
}