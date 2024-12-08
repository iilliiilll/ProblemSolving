import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;

        // 스택 생성
        Stack<Character> stack = new Stack<>();

        while (!(str = br.readLine()).equals(".")) {
            char[] arr = str.toCharArray();

            for (char c : arr) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() == '[') {
                        stack.push(c);
                        break;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() == '(') {
                        stack.push(c);
                        break;
                    } else if (stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

            stack.clear();
        }

        System.out.println(sb);

        br.close();
    }
}
