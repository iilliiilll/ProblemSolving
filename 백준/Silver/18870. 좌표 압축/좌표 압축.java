import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n개의 좌표 (1 <= n <= 1,000,000)
        int n = Integer.parseInt(br.readLine());

        // 압축 전후 배열
        int[] arr = new int[n];
        int[] sortedArr = new int[n];

        // 좌표 입력 (-10^9 <= arr[i] <= 10^9)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        // 좌표 압축
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;

        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // 출력
        for (int i : arr) {
            sb.append(rankMap.get(i)).append(" ");
        }
        System.out.println(sb);

        br.close();

    }
}