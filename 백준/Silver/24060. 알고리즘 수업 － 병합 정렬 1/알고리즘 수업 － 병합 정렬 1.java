import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int cnt = 0;
    static boolean b = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(A, 0, n - 1, k);

        if (!b) {
            System.out.println(-1);
        }
    }

    static void merge_sort(int[] A, int p, int r, int k) {
        if (p < r) {
            int q = ((p + r) / 2);
            merge_sort(A, p, q, k);
            merge_sort(A, q + 1, r, k);
            merge(A, p, q, r, k);
        }
    }

    static void merge(int[] A, int p, int q, int r, int k) {
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = A[i++];
        }

        while (j <= r) {
            tmp[t++] = A[j++];
        }

        i = p;
        t = 0;

        while (i <= r) {
            A[i++] = tmp[t++];
            cnt++;
            if (cnt == k) {
                System.out.println(A[--i]);
                System.exit(0);
            }
        }
    }
}