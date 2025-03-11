import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] f;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        f = new int[n + 1];

        fib(n);
        fibonacci(n);

        sb.append(a).append(" ").append(b);
        System.out.println(sb);
    }

    // fibonacci - 재귀호출
    static int fib(int n) {
        if (n == 1 || n == 2) {
            a++;
            return 1; // code 1
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    // fibonacci - 동적 계획법
    static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            b++;
            f[i] = f[i - 1] + f[i - 2]; // code 2
        }

        return f[n];
    }
}