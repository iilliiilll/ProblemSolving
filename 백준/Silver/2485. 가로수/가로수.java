import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가로수의 수 n (3 <= n <= 100,000)
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 가로수의 위치 (arr[i] <= 1,000,000,000)
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 거리의 차 배열에서 최대공약수 구하기
        int m = n - 1;
        int[] sub = new int[m];
        int gcd;

        for (int i = 0; i < m; i++) {
            sub[i] = arr[i + 1] - arr[i];
        }

        gcd = get_gcd(sub[0], sub[1]);

        for (int i = 2; i < m; i++) {
            gcd = get_gcd(gcd, sub[i]);
        }

        System.out.println((arr[arr.length - 1] - arr[0]) / gcd + 1 - n);

        br.close();
    }

    // 최대공약수 구하기
    private static int get_gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }
}