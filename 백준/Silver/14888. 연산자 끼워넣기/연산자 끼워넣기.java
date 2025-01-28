import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] num;
    static int[] op = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        bfs(num[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void bfs(int number, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch(i) {
                    case 0:
                        bfs(number + num[idx], idx + 1);
                        break;
                    case 1:
                        bfs(number - num[idx], idx + 1);
                        break;
                    case 2:
                        bfs(number * num[idx], idx + 1);
                        break;
                    case 3:
                        bfs(number / num[idx], idx + 1);
                        break;
                }

                op[i]++;
            }
        }
    }

}