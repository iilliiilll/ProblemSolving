import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        // 카드의 수 (1 <= n <= 500,000)
        int n = Integer.parseInt(br.readLine());

        // 큐에 삽입
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll(); // 카드 버리기
            q.add(q.poll()); // 카드 옮기기
        }

        System.out.println(q.poll());
    }
}