import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // a, b, c <= Integer.MAX_VALUE
        st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        // 나머지 구하기
        System.out.println(pow(a, b, c));
    }

    public static long pow(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }

        long half = pow(a, b / 2, c);
        long result = (half * half) % c;

        if (b % 2 == 1) {
            result = (result * a) % c;
        }

        return result;
    }

}