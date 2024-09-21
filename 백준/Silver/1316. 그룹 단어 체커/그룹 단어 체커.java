import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] word = str.toCharArray();

            if (groupWord(word)) {
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }

    static boolean groupWord(char[] word) {
        for (int i = 0; i < word.length - 1; i++) {
            if (word[i] < 'a' && 'z' < word[i]) {
                return false;
            }

            if (word[i] != word[i + 1]) {
                for (int j = i + 2; j < word.length; j++) {
                    if (word[i] == word[j]) {
                        return false;
                    }
                }
            }

        }

        return true;
    }
}