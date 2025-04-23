import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] count = new int[m];
        int sum = 0;

        // 누적합 -> 나머지
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum += Integer.parseInt(st.nextToken());
            sum %= m;

            count[sum] += 1;

        }

        long result = count[0];

        for (int i : count) {
            result += (long) i * (i - 1) / 2;
        }

        System.out.println(result);

    }
}