import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Balloon> dq = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Balloon b = new Balloon(i + 1, Integer.parseInt(st.nextToken()));
            dq.addLast(b);
        }

        Balloon curBal = dq.pollFirst();
        int curNum = curBal.number;
        int curVal = curBal.value;

        sb.append(curNum).append(" ");

        while (!dq.isEmpty()) {
            if (curVal > 0) {
                for (int i = 0; i < curVal - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < (-curVal); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }

            Balloon next = dq.pollFirst();
            curVal = next.value;
            sb.append(next.number).append(" ");
        }


        System.out.println(sb);
    }
}

class Balloon {
    int number;
    int value;

    public Balloon(int number, int value) {
        this.number = number;
        this.value = value;
    }
}