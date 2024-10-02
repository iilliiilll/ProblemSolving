import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int[] arr = new int[n];
        int j = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                arr[j] = i;
                j++;
            }
        }

        System.out.println(arr[k - 1]);


        br.close();
    }
}