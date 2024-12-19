import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<String> hs = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        String s1, s2;

        hs.add("ChongChong");

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s1 = st.nextToken();
            s2 = st.nextToken();

            if (hs.contains(s1) || hs.contains(s2)) {
                hs.add(s1);
                hs.add(s2);
            }
        }

        System.out.println(hs.size());
    }
}