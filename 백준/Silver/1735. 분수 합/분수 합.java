import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 분수 입력(<= 30,000)
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 분수 합과 최대공약수
        a *= d;
        c *= b;

        int i = a + c;
        int j = b * d;

        int gcd = get_gcd(i, j);

        // 출력
        sb.append(i / gcd).append(' ').append(j / gcd);
        System.out.println(sb);

        br.close();
    }

    // 최대공약수 구하기
    private static int get_gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }
}