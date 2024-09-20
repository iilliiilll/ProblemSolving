import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = (br.readLine()).toUpperCase();

        char[] arr1 = str.toCharArray();
        int[] arr2 = new int[26];

        for (char i : arr1) {
            int n = i - 'A';
            arr2[n] += 1;
        }

        int max = -999;
        int n = -1;
        int count = 0;

        for (int i = 0; i < arr2.length; i++) {
            if (max < arr2[i]) {
                max = arr2[i];
                n = i;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (max == arr2[i]) {
                count++;
            }
        }

        if (count > 1) {
            System.out.println("?");
        } else {
            System.out.println((char) (n + 'A'));
        }

        br.close();
    }
}