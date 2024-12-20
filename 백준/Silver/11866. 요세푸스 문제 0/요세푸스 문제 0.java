import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 큐 삽입
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        // 큐 제거
        sb.append("<");
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.add(q.poll());
            }

            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        System.out.println(sb);
    }
}