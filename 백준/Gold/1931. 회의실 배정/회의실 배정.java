import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[][] meetingTime;
    static int meetingCount = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 회의 수 : 1 <= n <= 100,000
        int n = Integer.parseInt(br.readLine());

        // 회의 정보 : 0 <= 시간 <= 2^31 - 1
        meetingTime = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            meetingTime[i][0] = startTime;
            meetingTime[i][1] = endTime;
        }

        // 정렬(종료시간 -> 시작시간)
        Arrays.sort(meetingTime, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        // 최대 회의 개수 구하기
        int end = meetingTime[0][1];

        for (int i = 1; i < n; i++) {

            if (meetingTime[i][0] >= end) {
                end = meetingTime[i][1];
                meetingCount += 1;
            }
        }

        System.out.println(meetingCount);
    }
}