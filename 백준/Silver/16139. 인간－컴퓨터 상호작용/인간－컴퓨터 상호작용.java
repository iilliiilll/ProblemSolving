import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[][] sum = new int[26][str.length() + 1];

        for (int i = 1; i <= str.length(); i++) {
            int searchCh = str.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                sum[j][i] = (j == searchCh ? sum[j][i - 1] + 1 : sum[j][i - 1]);
            }
        }

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int ch = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            sb.append(sum[ch][end] - sum[ch][start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}