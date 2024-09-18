import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n - 1; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i * 2 + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.print("*");
        }

        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < i + 2; j++) {
                System.out.print(" ");
            }

            for (int k = (2 * n - 3) - (2 * i); k > 0; k--) {
                System.out.print("*");
            }

            System.out.println();
        }


        br.close();
    }
}