import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];
        for (int i = 0; i < arr.length; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = ch[j];
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != '\0') {
                    System.out.print(arr[j][i]);
                } 
            }
        }


        br.close();
    }
}