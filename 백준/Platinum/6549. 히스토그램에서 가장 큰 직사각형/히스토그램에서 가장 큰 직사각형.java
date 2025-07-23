import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] histogram;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            // 직사각형의 수
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            histogram = new int[n];

            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(0, n - 1)).append('\n');
        }

        System.out.println(sb);
    }

    private static long getArea(int start, int end) {
        // 너비가 1이면 높이 반환
        if (start == end) {
            return histogram[start];
        }

        int mid = start + (end - start) / 2;

        long leftArea = getArea(start, mid);
        long rightArea = getArea(mid + 1, end);

        // 왼쪽 넓이, 오른쪽 넓이, 중간 넓이 중 큰 값 반환
        long max = Math.max(leftArea, rightArea);
        max = Math.max(max, getMidArea(start, end, mid));

        return max;
    }

    private static long getMidArea(int start, int end, int mid) {
        int toLeft = mid;
        int toRight = mid;

        long height = histogram[mid];

        long maxArea = height;

        while (start < toLeft && toRight < end) {
            if (histogram[toLeft - 1] < histogram[toRight + 1]) {
                toRight++;
                height = Math.min(height, histogram[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, histogram[toLeft]);
            }

            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < end) {
            toRight++;
            height = Math.min(height, histogram[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (start < toLeft) {
            toLeft--;
            height = Math.min(height, histogram[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}

