import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        
        char[] ch_arr = a.toCharArray();
        
        for(int i = 0; i < ch_arr.length; i++) {
            sb.append(ch_arr[i]).append('\n');
        }
        
        System.out.print(sb);
    }
}