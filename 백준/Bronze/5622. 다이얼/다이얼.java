import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] arr = str.toCharArray();
        int time = 0;

        for (char i : arr) {
            time += check_time(i);
        }

        System.out.println(time);

        br.close();

    }

    static int check_time(char c) {
        if (c <= 'C') {
            return 3;
        } else if (c <= 'F') {
            return 4;
        } else if (c <= 'I') {
            return 5;
        } else if (c <= 'L') {
            return 6;
        } else if (c <= 'O') {
            return 7;
        } else if (c <= 'S') {
            return 8;
        } else if (c <= 'V') {
            return 9;
        } else {
            return 10;
        }
    }

}