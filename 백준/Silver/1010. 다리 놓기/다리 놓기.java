import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // 0 < n <= m < 30
        // mCn 구하기
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int mnMinus = Math.min(m - n, n);

            long result = 1;
            for (int j = 0; j < mnMinus; j++) {
                result *= (m - j);
                result /= (j + 1);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}