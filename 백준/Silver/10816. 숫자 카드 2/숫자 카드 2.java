import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 가지고 있는 카드 수 n (1 <= n <= 500,000)
        int n = Integer.parseInt(br.readLine());

        // HashMap 생성
        HashMap<Integer, Integer> card = new HashMap<>();

        // 카드 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!card.containsKey(num)) { // 처음 나오는 숫자라면 추가
                card.put(num, 1);
            } else { // 이미 나온 숫자라면 값 변경
                card.put(num, card.get(num) + 1);
            }
        }

        // 구해야 할 카드 수 m (1 <= n <= 500,000)
        int m = Integer.parseInt(br.readLine());

        // 구할 카드 입력
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int find_num = Integer.parseInt(st.nextToken());

            if (card.get(find_num) != null) { // 구할 카드가 있는 경우
                sb.append(card.get(find_num)).append(" ");
            } else { // 구할 카드가 없는 경우
                sb.append(0).append(" ");
            }
        }

        // 출력
        System.out.println(sb);

        br.close();

    }
}