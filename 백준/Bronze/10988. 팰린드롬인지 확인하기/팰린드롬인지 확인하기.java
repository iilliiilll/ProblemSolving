import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int i = 0;
        int j = arr.length - 1;
        int result = 1;

        while (i < j) {
            if (arr[i] != arr[j]) {
                result = 0;
                break;
            }

            i++;
            j--;
        }
        System.out.println(result);

        br.close();
    }
}