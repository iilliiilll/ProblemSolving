import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());

        // 스택 생성
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < t; i++) {
            char[] arr = (br.readLine()).toCharArray();

            for (char c : arr) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

            stack.clear();
        }

        System.out.println(sb);

        br.close();
    }
}
