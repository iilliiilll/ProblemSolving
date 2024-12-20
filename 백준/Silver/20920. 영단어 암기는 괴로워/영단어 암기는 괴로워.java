import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<String, Integer> hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (str.length() >= m) {
                hm.put(str, hm.getOrDefault(str, 0) + 1);
            }
        }

        String[][] arr = new String[hm.size()][2];
        int index = 0;

        for (String s : hm.keySet()) {
            arr[index][0] = s;
            arr[index][1] = hm.get(s) + "";

            index++;
        }

        // 빈도 순 -> 길이 순 -> 사전 순 정렬
        Arrays.sort(arr, (s1, s2) -> {
            if (s1[1].equals(s2[1])) {
                if (s1[0].length() == s2[0].length()) {
                    return s1[0].compareTo(s2[0]); // 빈도, 길이 동일 -> 사전 순
                } else {
                    return s2[0].length() - s1[0].length(); // 빈도 동일 -> 길이 순(내림차순)
                }
            } else {
                return Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]); // 빈도 순(내림차순)
            }
        });

        for (String[] s : arr) {
            sb.append(s[0]).append("\n");
        }

        System.out.println(sb);
    }
}