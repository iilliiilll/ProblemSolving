import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> dq = new ArrayDeque<>();

        // n 입력
        int n = Integer.parseInt(br.readLine());
        int[] qs = new int[n];

        // 수열 A 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            qs[i] = Integer.parseInt(st.nextToken());
        }

        // 수열 B 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (qs[i] == 0) {
                dq.addLast(num);
            }
        }

        // m 입력
        int m = Integer.parseInt(br.readLine());

        // 수열 C 입력
        st = new StringTokenizer(br.readLine());

        if (dq.isEmpty()) {
            for (int i = 0; i < m; i++) {
                sb.append(Integer.parseInt(st.nextToken())).append(" ");
            }
        } else {
            for (int i = 0; i < m; i++) {
                dq.addFirst(Integer.parseInt(st.nextToken()));
                sb.append(dq.pollLast()).append(" ");
            }
        }

        System.out.println(sb);
    }
}