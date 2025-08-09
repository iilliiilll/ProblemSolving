import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        char[] ch_arr = br.readLine().toCharArray();
        
        for(int i = 0; i < ch_arr.length; i++) {
            if(Character.isUpperCase(ch_arr[i])) {
                sb.append(Character.toLowerCase(ch_arr[i]));
            } else {
                sb.append(Character.toUpperCase(ch_arr[i]));
            }
        }
        
        System.out.print(sb);
    }
}