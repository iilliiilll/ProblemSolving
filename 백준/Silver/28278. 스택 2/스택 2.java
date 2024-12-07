import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 명령의 수 n (1 <= n <= 1,000,000)
        int n = Integer.parseInt(br.readLine());

        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int x = 0;

            // 정수 x (1 <= x <= 100,000)
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (order) {
                case 1:
                    stack.push(x);
                    break;
                case 2:
                    sb.append(stack.empty() ? -1 : stack.pop()).append('\n');
                    break;
                case 3:
                    sb.append(stack.size()).append('\n');
                    break;
                case 4:
                    sb.append(stack.empty() ? 1 : 0).append('\n');
                    break;
                case 5:
                    sb.append(stack.empty() ? -1 : stack.peek()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}
