import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, n) - 1).append('\n');

        // 1에서 3으로 이동. 나머지 : 2
        hanoi(n, 1, 3, 2);

        System.out.println(sb);
    }

    static void hanoi(int n, int start, int end, int mid) {
        if (n == 1) {
            sb.append(start + " " + end + "\n");

            return;
        }

        hanoi(n - 1, start, mid, end);

        sb.append(start + " " + end + "\n");

        hanoi(n - 1, mid, end, start);
    }
}