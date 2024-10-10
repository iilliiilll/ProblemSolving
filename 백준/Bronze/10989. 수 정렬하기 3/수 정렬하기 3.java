import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // n개의 수, 1 <= n <= 10,000,000
        int[] counting = new int[10001]; // 1 <= 입력할 자연수 <= 10,000

        for (int i = 0; i < n; i++) {
            counting[Integer.parseInt(br.readLine())]++; // 입력받은 값에 해당하는 인덱스 +1
        }

        for (int i = 1; i < counting.length; i++) { // 오름차순
            int k = counting[i]; // k : 해당 인덱스가 나타나 횟수

            if (k != 0) { // 1번 이상 나왔다면
                for (int j = 0; j < k; j++) {
                    sb.append(i).append('\n');
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}