import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];

        // 2차원 누적합
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                arr[i][j] =
                    Integer.parseInt(st.nextToken()) + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j
                        - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1];

            sb.append(sum).append('\n');
        }

        System.out.println(sb);

    }
}