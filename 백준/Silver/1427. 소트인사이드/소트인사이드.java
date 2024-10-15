import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1 <= n <= 1,000,000,000
        int n = Integer.parseInt(br.readLine());

        // 숫자 -> 문자열
        String str = n + "";

        // 문자열 -> 문자 배열
        char[] ch = str.toCharArray();

        // ch 배열 오름차순 정렬
        Arrays.sort(ch);

        for (char c : ch) {
            sb.append(c);
        }

        // 뒤집기
        sb.reverse();

        System.out.println(sb);

        br.close();
    }
}