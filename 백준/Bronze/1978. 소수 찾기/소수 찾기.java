import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = 0;

            for (int j = 1; j <= x; j++) {
                if (x % j == 0) {
                    y++;
                }
            }

            if (y == 2) {
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}