import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;

        while ((n = Integer.parseInt(br.readLine())) != -1) {
            int[] arr = new int[n];
            int j = 0;
            int sum = 0;
            int k = 1;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    arr[j++] = i;
                }
            }

            if (n == sum) {
                System.out.print(n + " = " + 1);
                while (arr[k] != 0) {
                    System.out.print(" + " + arr[k++]);
                }
                System.out.println();
            } else {
                System.out.println(n + " is NOT perfect.");
            }

        }

        br.close();
    }
}