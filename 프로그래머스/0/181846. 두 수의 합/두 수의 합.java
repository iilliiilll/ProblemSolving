import java.math.*;

class Solution {
    public String solution(String a, String b) {
//         BigInteger a1 = new BigInteger(a);
//         BigInteger b1 = new BigInteger(b);
        
//         return a1.add(b1).toString();
        
        
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int idx = 0;
        int sum = 0;
        
        while(idx < a.length() || idx < b.length() || carry > 0) {
            int n1 = idx < a.length() ? Integer.parseInt(a.substring(idx, idx + 1)) : 0 ;
            int n2 = idx < b.length() ? Integer.parseInt(b.substring(idx, idx + 1)) : 0 ;
            
            sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            
            idx++;
        }
        return sb.reverse().toString();
    }
}