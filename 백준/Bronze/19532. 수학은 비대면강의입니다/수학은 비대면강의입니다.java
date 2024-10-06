import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x, y;

        

        if (b == 0) {
            x = c / a;
            y = (f - d * x) / e;
        } else {
            x = (c * e - b * f) / (a * e - b * d);
            y = (c - a * x) / b;
        }

        System.out.println(x + " " + y);


        br.close();
    }
}