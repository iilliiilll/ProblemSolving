import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[100][100];
        int count = 0;

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if ((x + j) < 100 && (y + k) < 100) {
                        arr[x + j][y + k] = 1;
                    }
                }
            }

        }

        for (int[] n : arr) {
            for (int m : n) {
                if (m == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}