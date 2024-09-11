import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int i, j, k;

        int[] arr = new int[n];

        for (int x = 0; x < m; x++) {
            i = sc.nextInt();
            j = sc.nextInt();
            k = sc.nextInt();
            for (int y = i - 1; y < j; y++) {
                arr[y] = k;
            }
        }

        for (int z : arr) {
            System.out.print(z + " ");
        }

    }
}