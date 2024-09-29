import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(br.readLine());
            Change(x);
        }

        br.close();
    }

    static void Change(int x) {
        int a, b, c, d;

        a = x / 25;
        x -= 25 * a;

        b = x / 10;
        x -= 10 * b;

        c = x / 5;
        x -= 5 * c;

        d = x;

        System.out.println(a + " " + b + " " + c + " " + d);
    }
}