import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] cnt = new int[1];

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            cnt[0] = 0;

            sb.append(isPalindrome(s, cnt)).append(" ").append(cnt[0]).append("\n");
        }

        System.out.println(sb);
    }

    public static int recursion(String s, int l, int r, int[] cnt) {
        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            cnt[0]++;
            return recursion(s, l + 1, r - 1, cnt);
        }
    }

    public static int isPalindrome(String s, int[] cnt) {
        cnt[0]++;
        return recursion(s, 0, s.length() - 1, cnt);
    }
}