import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int day = (int) Math.ceil((double) (height - down) / (up - down));
        System.out.println(day);

        br.close();
    }
}