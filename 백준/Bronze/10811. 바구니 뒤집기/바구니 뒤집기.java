import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int temp;

            for (int j = x; j <= y; j++, y--) {
                temp = arr[j];
                arr[j] = arr[y];
                arr[y] = temp;
            }
        }

        for (int i : arr) {
            System.out.print((i + 1) + " ");
        }

    }
}