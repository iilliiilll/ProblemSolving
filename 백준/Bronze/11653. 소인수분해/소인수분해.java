import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (n == 1) {
                break;
            }

            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    n /= i;
                    System.out.println(i);
                    break;
                }
            }
        }

        br.close();
    }
}