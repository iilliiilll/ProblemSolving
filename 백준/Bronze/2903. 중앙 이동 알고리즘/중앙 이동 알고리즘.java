import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        double m = 1 + Math.pow(2, n);
        m = Math.pow(m, 2);

        System.out.println((int) m);


        br.close();
    }
}