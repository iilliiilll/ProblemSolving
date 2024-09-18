import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int[] arr1 = new int[6];
        int[] arr2 = {1, 1, 2, 2, 2, 8};
        int[] arr3 = new int[6];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            arr3[i] = arr2[i] - arr1[i];
            System.out.print(arr3[i] + " ");
        }

        br.close();
    }
}