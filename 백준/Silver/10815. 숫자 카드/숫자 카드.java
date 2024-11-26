import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 카드 입력
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> card = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card.add(Integer.parseInt(st.nextToken()));
        }

        // 구할 카드 입력
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 가지고 있는지의 여부 판단
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());

            if (card.contains(find)) {
                sb.append(1).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }

        // 출력
        System.out.println(sb.toString().trim());

        br.close();

    }
}