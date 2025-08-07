import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int count = 0;

            int m = Integer.parseInt(br.readLine());
            sb.append((m + 1) / 2).append('\n');

            for (int j = 0; j < (m / 10) + 1; j++) {
                st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());

                    if (maxHeap.isEmpty() || num < maxHeap.peek()) {
                        maxHeap.add(num);
                    } else {
                        minHeap.add(num);
                    }

                    // 균형 맞추기
                    if (maxHeap.size() > minHeap.size() + 1) {
                        minHeap.add(maxHeap.poll());
                    } else if (minHeap.size() > maxHeap.size()) {
                        maxHeap.add(minHeap.poll());
                    }

                    if ((maxHeap.size() + minHeap.size()) % 2 == 1) {
                        sb.append(maxHeap.peek()).append(" ");
                        count++;

                        if (count % 10 == 0) {
                            sb.append('\n');
                        }
                    }
                }

            }

            if (count % 10 != 0) {
                sb.append('\n');
            }

            maxHeap.clear();
            minHeap.clear();
        }

        System.out.println(sb);
    }
}