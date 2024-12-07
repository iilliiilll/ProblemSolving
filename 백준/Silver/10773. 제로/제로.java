import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // k ( 1 <= k <= 100,000)
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            // 0 <= n <= 1,000,000
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        // 합 계산
        int sum = 0;

        while (!stack.empty()) {
            sum += stack.pop();
        }

        System.out.println(sum);

        br.close();
    }
}
