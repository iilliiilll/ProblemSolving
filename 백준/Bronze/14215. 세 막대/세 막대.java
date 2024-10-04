import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[3];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        Arrays.sort(arr);

        if (arr[2] >= arr[0] + arr[1]) {
            arr[2] = arr[0] + arr[1] - 1;
            sum = arr[0] + arr[1] + arr[2];
        }

        System.out.println(sum);

        br.close();
    }
}