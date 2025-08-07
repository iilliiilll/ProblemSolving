import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[n];
        int listLen = 1;
        list[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (list[listLen - 1] < arr[i]) {
                list[listLen] = arr[i];
                listLen++;
            } else {
                int key = arr[i];
                int start = 0;
                int end = listLen;

                while (start < end) {
                    int mid = start + (end - start) / 2;

                    if (list[mid] < key) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }

                list[start] = key;
            }
        }

        System.out.println(listLen);
    }

}