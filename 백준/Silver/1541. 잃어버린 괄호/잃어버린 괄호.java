import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = 0;

        int count = st.countTokens();

        for (int i = 0; i < count; i++) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            int temp = 0;
            int count2 = st2.countTokens();

            for (int j = 0; j < count2; j++) {
                temp += Integer.parseInt(st2.nextToken());
            }

            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);
    }
}