import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= n <= 1,000,000
        int n = Integer.parseInt(br.readLine());

        // 횟수 배열 생성
        int[] count = new int[n + 1];

        count[1] = 0;

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0 && i % 3 == 0) { // 2, 3의 배수
                    count[i] = Math.min(Math.min(count[i - 1], count[i / 2]), count[i / 3]) + 1;
                } else if (i % 3 == 0) { // 3의 배수
                    count[i] = Math.min(count[i - 1], count[i / 3]) + 1;
                } else if (i % 2 == 0) { // 2의 배수
                    count[i] = Math.min(count[i - 1], count[i / 2]) + 1;
                } else { // 둘 중 아무것도 아닐 때
                    count[i] = count[i - 1] + 1;
                }
            }
        }

        System.out.println(count[n]);
    }
}