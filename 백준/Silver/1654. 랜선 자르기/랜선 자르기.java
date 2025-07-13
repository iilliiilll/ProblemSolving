import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static long[] cable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // k, n
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 랜선 길이
        cable = new long[k];

        for (int i = 0; i < k; i++) {
            cable[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(cable);

        // 랜선 최대 길이 찾기
        System.out.println(getMaxLen(n) - 1);
    }

    private static long getMaxLen(int n) {
        long start = 1;
        long end = cable[cable.length - 1] + 1;

        while (start < end) {
            long mid = start + (end - start) / 2;
            long count = 0;

            for (long c : cable) {
                count += c / mid;
            }

            if (n <= count) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}

