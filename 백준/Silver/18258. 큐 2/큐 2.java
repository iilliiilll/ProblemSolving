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
        int last = -1; // 마지막 push 값 저장

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    q.add(last);
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : last).append('\n');
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}