import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 3 <= n <= 5,000

        int three = 0; // 3킬로 봉지
        int five; // 5킬로 봉지
        int max_five = n / 5; // 5킬로 봉지의 최대 개수
        int rest; // 남은 봉지의 수
        int sum = 0; // 봉지의 최소 개수

        for (five = max_five; five >= 0; five--) {
            rest = n - 5 * five;

            if (rest % 3 == 0) {
                three = rest / 3;
                sum = three + five;
                break;
            }
        }

        System.out.println((sum == 0) ? -1 : sum);

        sc.close();
    }
}