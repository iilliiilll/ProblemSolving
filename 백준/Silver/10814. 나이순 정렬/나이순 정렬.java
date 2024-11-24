import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 회원 수 n (1 <= n <= 100,000)
        int n = Integer.parseInt(br.readLine());

        // n x 2 배열 생성
        String[][] str_arr = new String[n][2];

        // 나이, 이름 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            str_arr[i][0] = st.nextToken();
            str_arr[i][1] = st.nextToken();
        }

        // 나이 -> 가입순 정렬
        Arrays.sort(str_arr, (e1, e2) -> {
            int age1 = Integer.parseInt(e1[0]);
            int age2 = Integer.parseInt(e2[0]);

            return age1 - age2;
        });

        // 출력
        for (int i = 0; i < n - 1; i++) {
            sb.append(str_arr[i][0]).append(" ").append(str_arr[i][1]).append('\n');
        }
        sb.append(str_arr[n - 1][0]).append(" ").append(str_arr[n - 1][1]);
        System.out.println(sb);

        br.close();

    }
}