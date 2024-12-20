import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> hm = new HashMap<>();

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
        System.out.println((int) ave);


        // 2. 중앙값
        Arrays.sort(arr);
        System.out.println(arr[n / 2]);


        // 3. 최빈값
        // 나온 횟수의 최댓값
        int max = -1;
        for (int i : hm.keySet()) {
            if (hm.get(i) > max) {
                max = hm.get(i);
            }
        }

        // max가 나온 횟수 구하기
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : hm.keySet()) {
            if (max == hm.get(i)) {
                list.add(i);
            }
        }

        Collections.sort(list);

        // 1번 나왔다면 바로 출력
        // 여러 번 나왔다면 두 번째로 작은 값 출력
        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            list.remove(0);
            System.out.println(list.get(0));
        }



        // 4. 범위
        System.out.println(arr[n - 1] - arr[0]);


    }
}