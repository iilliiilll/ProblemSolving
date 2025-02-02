import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N; // 인원 수
    static int[][] stats; // 능력치
    static int[] person; // 사람 수 배열
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 4 <= n <= 20 (n은 짝수)

        stats = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        person = new int[N]; // 0으로 초기화
        person[0] = 1;

        getMin(1, 0);

        System.out.println(MIN);
    }

    // 매개변수 : 현재 인원 수
    static void getMin(int count, int idx) {
        if (count == N / 2) {
            int start = 0;
            int link = 0;

            int[] temp1 = new int[N / 2];
            int[] temp2 = new int[N / 2];

            int t1 = 0;
            int t2 = 0;

            for (int i = 0; i < N; i++) {
                if (person[i] == 0) {
                    temp1[t1++] = i; // ex. [1, 3, 6]
                } else {
                    temp2[t2++] = i; // ex. [2, 4, 5]
                }
            }

            for (int i = 0; i < N / 2 - 1; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    start += (stats[temp1[i]][temp1[j]] + stats[temp1[j]][temp1[i]]);
                }
            }

            for (int i = 0; i < N / 2 - 1; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    link += (stats[temp2[i]][temp2[j]] + stats[temp2[j]][temp2[i]]);
                }
            }

            int sub = Math.abs(start - link);

            if (sub < MIN) {
                MIN = sub;
            }

            return;
        }

        for (int i = idx; i < person.length; i++) {
            if (person[i] == 0) {
                person[i] = 1;
                getMin(count + 1, i + 1);
                person[i] = 0;
            }
        }
    }

}