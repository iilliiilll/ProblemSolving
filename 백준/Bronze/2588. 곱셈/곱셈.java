import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();

        int c1, c2, c3;
        c1 = (b % 10) * a;
        c2 = ((b / 10) % 10) * a;
        c3 = (b / 100) * a;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c1 + c2 * 10 + c3 * 100);
    }
}