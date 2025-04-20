import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] ch_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ch_arr = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            countChar(ch, l, r);
        }

        System.out.println(sb);
    }

    public static void countChar(char ch, int l, int r) {
        int count = 0;

        for (int i = l; i <= r; i++) {
            if (ch_arr[i] == ch) {
                count += 1;
            }
        }

        sb.append(count).append('\n');
    }
}