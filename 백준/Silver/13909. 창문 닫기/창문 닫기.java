import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 창문의 개수, 사람의 수 (1 <= n <= 2,100,000,000) (21억)
        int n = Integer.parseInt(br.readLine());

        // 약수의 개수가 홀수인 수 찾기(제곱수)
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}
