import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int sum = 1;
        int cnt = 1;

        while (true) {
            if (x <= sum) {
                x = sum - x;

                if (cnt % 2 == 0) {
                    System.out.println((cnt - x) + "/" + (x + 1));
                    break;
                } else {
                    System.out.println((x + 1) + "/" + (cnt - x));
                    break;
                }
            }

            cnt++;
            sum += cnt;
        }

        br.close();
    }
}