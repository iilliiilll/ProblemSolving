import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            int end = str.length() - 1;
            System.out.println(arr[0] + "" + arr[end]);
        }

    }
}