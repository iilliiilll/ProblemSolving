import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정수 입력 (a, b < 10^3) (10^3 < a, b < 10^8)
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // 최소공배수 계산
        long gcd = get_gcd(a, b);
        long lcm = (a / gcd) * b;

        // 출력
        System.out.println(lcm);

        br.close();
    }

    private static long get_gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}