import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 1 <= n <= 500,000 (n은 홀수)
        int n = Integer.parseInt(br.readLine());

        double sum = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            sum += num;
            arr[i] = num;
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // 1. 산술 평균
        double ave = Math.round((sum / n));
        sb.append((int) ave).append("\n");

        // 2. 중앙값
        Arrays.sort(arr);
        sb.append(arr[n / 2]).append("\n");

        // 3. 최빈값
        // 나온 횟수의 최댓값
        int max = -1;
        for (int i : hm.values()) {
            if (i > max) {
                max = i;
            }
        }

        // 최빈값 저장
        for (int i : hm.keySet()) {
            if (max == hm.get(i)) {
                list.add(i);
            }
        }

        Collections.sort(list);

        // 1번 나왔다면 바로 출력
        // 그 이상이면 두 번째로 작은 값 출력
        if (list.size() == 1) {
            sb.append(list.get(0)).append("\n");
        } else {
            list.remove(0);
            sb.append(list.get(0)).append("\n");
        }

        // 4. 범위
        sb.append(arr[n - 1] - arr[0]);

        // 출력
        System.out.println(sb);
    }
}