import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int next = 1;
        boolean b = true;

        // 번호 표 입력
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (next == cur) {
                next++;
            } else {
                while (!stack.isEmpty() && stack.peek() == next) {
                    stack.pop();
                    next++;
                }

                stack.push(cur);
            }
        }

        // 출력
        while (!stack.isEmpty()) {
            if (stack.pop() != next) {
                System.out.println("Sad");
                return;
            }
            next++;
        }

        System.out.println("Nice");

        br.close();
    }
}