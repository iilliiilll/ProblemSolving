class Solution {
    public String solution(int a, int b) {
        String[] str = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] last = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = b;
        
        for(int i = 0; i < a; i++) {
            days += last[i];
        }
        
        days %= 7;
        
        return str[days];
    }
}