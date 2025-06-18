import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 개수 n : 2 <= n <= 100,000
        int n = Integer.parseInt(br.readLine());

        // 도로의 길이 road : 1 <= road <= 1,000,000,000
        int[] road = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        // 리터당 가격 oil : 1 <= oil <= 1,000,000,000
        int[] oil = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }

        // 최소 비용 구하기
        int minOil = oil[0];
        double price = minOil * road[0];

        for (int i = 1; i < n - 1; i++) {
            // 더 싼 기름
            if (minOil > oil[i]) {
                minOil = oil[i];
            }

            price += minOil * road[i];
        }

        System.out.println((int) price);

    }
}