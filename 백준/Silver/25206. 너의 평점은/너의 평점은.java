import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        double grade = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String obj = st.nextToken();
            double n = Double.parseDouble(st.nextToken());
            String s = st.nextToken();

            if (s.equals("P")) {
                continue;
            } else {
                double m = change(s);
                sum += n;
                grade += n * m;
            }
        }

        System.out.println(grade / sum);

        br.close();
    }


    static double change(String s) {
        double m = 0;

        switch (s) {
            case "A+":
                m = 4.5;
                break;
            case "A0":
                m = 4.0;
                break;
            case "B+":
                m = 3.5;
                break;
            case "B0":
                m = 3.0;
                break;
            case "C+":
                m = 2.5;
                break;
            case "C0":
                m = 2.0;
                break;
            case "D+":
                m = 1.5;
                break;
            case "D0":
                m = 1.0;
                break;
            case "F":
                m = 0.0;
                break;
        }

        return m;
    }
}