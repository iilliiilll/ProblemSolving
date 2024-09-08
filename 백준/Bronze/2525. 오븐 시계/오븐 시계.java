import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h, m, time;
        h = sc.nextInt();
        m = sc.nextInt();
        time = sc.nextInt();

        h += time / 60;
        m += time % 60;

        if (m >= 60) {
            h += m / 60;
            m = m % 60;
        }

        if (h >= 24) {
            h -= 24;
        }

        System.out.println(h + " " + m);

    }
}