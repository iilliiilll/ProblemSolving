import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1 <= n <= 10, 1 <= k <= 100,000,000
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 동전 가치(오름차순)
        int[] coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // 최솟값 구하기
        int min = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) {
                break;
            }

            if (coin[i] <= k) {
                int div = k / coin[i];

                k -= coin[i] * div;
                min += div;
            }
        }

        System.out.println(min);

    }
}