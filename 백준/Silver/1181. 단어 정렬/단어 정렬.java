import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n개의 단어(1 <= n <= 20,000)
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, (str1, str2) -> {
            if (str1.length() == str2.length()) {
                return str1.compareTo(str2);
            } else {
                return str1.length() - str2.length();
            }
        });

        // 중복 제거 후 출력
        sb.append(str[0]).append('\n');
        for (int i = 1; i < n; i++) {
            if (!(str[i].equals(str[i - 1]))) {
                sb.append(str[i]).append('\n');
            }
        }
        System.out.println(sb);

        br.close();

    }
}