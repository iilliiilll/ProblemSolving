import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 포켓몬 수 n, 문제의 수 m (1 <= n, m <= 100,000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 해시맵 생성
        HashMap<String, String> m1 = new HashMap<>();
        HashMap<String, String> m2 = new HashMap<>();

        // 포켓몬 입력
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            m1.put((i + ""), name);
            m2.put(name, (i + ""));
        }

        // 문제
        for (int i = 0; i < m; i++) {
            String find = br.readLine();

            if (m1.containsKey(find)) {
                sb.append(m1.get(find)).append('\n');
            } else if (m2.containsKey(find)) {
                sb.append(m2.get(find)).append('\n');
            }
        }

        System.out.println(sb.toString().trim());

        br.close();

    }
}