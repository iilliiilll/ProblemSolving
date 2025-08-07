import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absCompare = Integer.compare(Math.abs(a), Math.abs(b));
            return absCompare != 0 ? absCompare : Integer.compare(a, b);
        });

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            } else {
                pq.add(num);
            }
        }

        System.out.println(sb);
    }

}