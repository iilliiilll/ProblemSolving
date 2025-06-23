import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static final int p = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1 <= n <= 4,000,000, 0 <= k <= n
        st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        // n! mod p
        long a = factorial(n);

        // k! * (n-k)! mod p
        long b = factorial(k) * factorial(n - k) % p;

        // 결과
        System.out.println(a * pow(b, p - 2) % p);
    }

    public static long factorial(long n) {
        long f = 1;

        for (int i = 1; i <= n; i++) {
            f = (f * i) % p;
        }

        return f;
    }

    public static long pow(long x, long y) {
        if (y == 1) {
            return x % p;
        }

        long temp = pow(x, y / 2);
        long result = (temp * temp) % p;

        if (y % 2 == 1) {
            return result * x % p;
        }

        return result;
    }

}