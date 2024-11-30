import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1 <= n, m <= 500,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // HashSet 생성
        HashSet<String> name1 = new HashSet<>();
        HashSet<String> name2 = new HashSet<>();

        // 입력
        for (int i = 0; i < n; i++) {
            name1.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            name2.add(br.readLine());
        }

        // 중복 원소들을 배열로 변환
        name1.retainAll(name2);
        Object[] str = name1.toArray();
        Arrays.sort(str);

        // 출력
        System.out.println(str.length);
        for (Object o : str) {
            System.out.println(o);
        }


        br.close();

    }
}