import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 출입 기록 수 (2 <= n <= 10^6)
        int n = Integer.parseInt(br.readLine());

        // 이름이 들어갈 HashSet 생성
        HashSet<String> nameSet = new HashSet<>();

        // 출입 기록
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String list = st.nextToken();

            if (list.equals("enter")) {
                nameSet.add(name);
            } else if (list.equals("leave")) {
                nameSet.remove(name);
            }
        }

        // 배열 변환 후 정렬
        Object[] str = nameSet.toArray();
        Arrays.sort(str);

        // 역순 출력
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]).append('\n');
        }

        System.out.println(sb.toString().trim());

        br.close();

    }
}