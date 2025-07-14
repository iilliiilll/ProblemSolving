import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집 n (2 <= n <= 200,000), 공유기 c (2 <= c <= n)
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        house = new int[n];

        // 집 좌표 x (0 <= x <= 1,000,000,000)
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        // 거리 기준
        int start = 1;
        int end = house[house.length - 1] - house[0] + 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (getWifi(mid) < c) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
    }

    private static int getWifi(int distance) {
        int count = 1;
        int before = house[0];

        for (int i = 1; i < house.length; i++) {
            if (house[i] - before >= distance) {
                count++;
                before = house[i];
            }
        }

        return count;
    }
}

