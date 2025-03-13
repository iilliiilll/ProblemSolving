import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 계단의 개수 (1 <= n <= 300)
        int n = Integer.parseInt(br.readLine());

        // 점수 (1 <= score[i] <= 10,000)
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 최고점수
        int[] score = new int[n + 1];
        score[1] = stairs[1];

        if (n >= 2) {
            score[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= n; i++) {
            score[i] = stairs[i] + Math.max(score[i - 2], score[i - 3] + stairs[i - 1]);
        }

        System.out.println(score[n]);

    }
}

/*
score[i] : i번째 계단까지의 최고점수
score[i] = stairs[i] + Math.max( score[i - 2], score[i - 3] + stairs[i - 1] )
*/