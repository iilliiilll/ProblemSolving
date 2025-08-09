class Solution {
    public int solution(int a, int b) {
        String s1 = (a + "") + (b + "");
        String s2 = (b + "") + (a + "");
        
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        
        return i1 > i2 ? i1 : i2;
    }
}