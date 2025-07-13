import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 자연수 n (1 <= n <= 100,000)
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        // 자연수 m (1 <= m <= 100,000)
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 보유 카드 수 구하기
        for (int num : b) {
            sb.append(isExist(num) ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }

    public static boolean isExist(int num) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num == a[mid]) {
                return true;
            } else if (num < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
