import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 99999;

        while (m <= n) {
            if (isPrime(m)) {
                sum += m;
                min = Math.min(min, m);
            }

            m++;
        }

        if (sum != 0) {
            System.out.println(sum + "\n" + min);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    static boolean isPrime(int m) {
        int cnt = 0;

        for (int i = 1; i <= m; i++) {
            if (m % i == 0) {
                cnt++;
            }
        }

        if (cnt == 2) {
            return true;
        }

        return false;
    }
}