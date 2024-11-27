import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출입 기록 수 (2 <= n <= 10^6)
        int n = Integer.parseInt(br.readLine());

        // 이름이 들어갈 HashSet 생성
        HashSet<String> nameSet = new HashSet<>();

        // 출입 기록
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String list = st.nextToken();

            if (list.equals("enter")) {
                nameSet.add(name);
            } else if(list.equals("leave")){
                nameSet.remove(name);
            }

        }

        Object[] str = nameSet.toArray();
        Arrays.sort(str);

        for (int i = str.length - 1; i >= 0; i--) {
            System.out.println(str[i]);
        }

        br.close();

    }
}