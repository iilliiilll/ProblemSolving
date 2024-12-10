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

        int n = Integer.parseInt(br.readLine());

        int last = 999;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if (order.equals("push")) {
                int x = Integer.parseInt(st.nextToken());

                q.add(x);

                last = x;
            } else if (order.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(q.poll()).append('\n');
                }
            } else if (order.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (order.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            } else if (order.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(q.peek()).append('\n');
                }
            } else if (order.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(last).append('\n');
                }
            }

        }

        System.out.println(sb);

        br.close();
    }
}