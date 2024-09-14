import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = str.length() - 1; i >= 0; i--) {
            int n = str.charAt(i) - 'a';
            arr[n] = i;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}