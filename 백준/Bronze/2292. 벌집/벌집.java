import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) - 1;


        if (n == 0) {
            System.out.println(1);
        } else {
            int a = 1;
            int b = 1;
            int cnt = 1;
            int room = 2;

            while (true) {
                if (a <= n && n <= 6 * b) {
                    System.out.println(room);
                    break;
                }

                a = 6 * b + 1;
                cnt++;
                b += cnt;
                room++;
            }
        }


        br.close();
    }
}