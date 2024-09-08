import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, c, same;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println(10000 + a * 1000);
        } else if (a != b && b != c && c != a) {
            System.out.println(Math.max(Math.max(a, b), c) * 100);
        } else {
            if (a == b) {
                same = a;
            } else if (b == c) {
                same = b;
            } else {
                same = c;
            }
            System.out.println(1000 + same * 100);
        }

    }
}