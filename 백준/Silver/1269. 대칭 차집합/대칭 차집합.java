import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= n, m <= 200,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // HashSet 생성
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();

        // 원소의 값 <= 100,000,000
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        // 대칭 차집합
        int plus_size = a.size() + b.size();
        a.retainAll(b);
        int minus_size = a.size();

        System.out.println(plus_size - 2 * minus_size);


        br.close();

    }
}