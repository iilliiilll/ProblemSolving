import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 1 <= n <= 1,000
        int k = sc.nextInt(); // 1 <= k <= n
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // 0 <= x <= 10,000
        }

        Arrays.sort(arr);

        System.out.println(arr[n - k]);

        sc.close();
    }
}