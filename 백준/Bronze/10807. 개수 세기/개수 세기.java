import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, cnt, v;
        n = sc.nextInt();
        cnt = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        v = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == v) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}