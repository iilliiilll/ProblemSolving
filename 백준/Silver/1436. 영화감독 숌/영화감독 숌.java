import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n의 범위 : 1 <= n <= 10,000
        int count = 0; // 6이 적어도 3개 이상 들어가는 경우
        int i = 0; // 전체 자연수 탐색
        String s; // i를 문자열로 변환하여 저장

        while (n != count) {
            s = ++i + "";

            if (s.contains("666")) {
                count++;
            }
        }

        System.out.println(i);

        sc.close();
    }
}