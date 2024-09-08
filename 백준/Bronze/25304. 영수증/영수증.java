import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result, n, a, b, sum;
        result = sc.nextInt();
        n = sc.nextInt();
        sum = 0;

        for (int i = 1; i <= n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            sum += a * b;
        }

        System.out.println(result == sum ? "Yes" : "No");

    }
}