import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 1,000,000
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // |arr[i]| <= 1,000,000
        }

        Arrays.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

        br.close();
    }
}