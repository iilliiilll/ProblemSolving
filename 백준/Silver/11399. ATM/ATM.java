import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람의 수 : 1 <= n <= 1,000
        int n = Integer.parseInt(br.readLine());

        // 인출하는데 걸리는 시간 : 1 <= p <= 1,000
        int[] time = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(time);

        int sum = time[0];

        for (int i = 1; i < n; i++) {
            time[i] += time[i - 1];
            sum += time[i];
        }

        System.out.println(sum);

    }
}