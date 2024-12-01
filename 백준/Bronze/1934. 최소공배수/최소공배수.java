import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 개수
        int t = Integer.parseInt(br.readLine());

        // 최대공약수로 최소공배수 구하기
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = Math.min(a, b); j > 0; j--) {
                if (a % j == 0 && b % j == 0) {
                    sb.append(a * b / j).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);

        br.close();

    }
}