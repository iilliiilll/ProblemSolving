import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 개수 입력 (1 <= n, m <= 10,000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // HashSet에 문자열 추가
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // 포함 개수 카운트
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            if (set.contains(br.readLine())) {
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();

    }
}