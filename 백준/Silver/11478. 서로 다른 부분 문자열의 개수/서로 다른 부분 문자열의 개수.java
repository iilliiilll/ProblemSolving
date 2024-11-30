import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이 <= 1,000 
        String s = br.readLine();

        // HashSet 생성
        HashSet<String> set = new HashSet<>();

        // 부분 문자열
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                set.add(s.substring(i, j + 1));
            }
        }
        
        // 출력
        System.out.println(set.size());

        br.close();

    }
}