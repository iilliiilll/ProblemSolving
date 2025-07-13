import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start = 0;
        int end = -1;

        // 나무의 수 n (1 <= n <= 1,000,000), 나무의 길이 m (1 <= m <= 2,000,000,000)
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new int[n];

        // 나무의 높이 h (0 <= h <= 1,000,000,000)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
        }

        end++;

        while (start < end) {
            int mid = start + (end - start) / 2;
            long result = 0;

            for (int t : tree) {
                if (t - mid > 0) {
                    result += (t - mid);
                }
            }

            if (result >= m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start - 1);
    }
}

