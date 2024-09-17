import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String a = st.nextToken();
        String b = st.nextToken();

        int x = Change(a);
        int y = Change(b);

        System.out.println(Math.max(x, y));


        br.close();

    }

    public static int Change(String str) {
        int i = str.charAt(2) - '0';
        int j = str.charAt(1) - '0';
        int k = str.charAt(0) - '0';

        return 100 * i + 10 * j + k;
    }


}