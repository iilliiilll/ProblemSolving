class Solution {
    public String[] solution(String[] strArr) {
        for(int i = 0; i < strArr.length; i++) {
            String s = strArr[i];
            
            strArr[i] = i % 2 == 0 ? s.toLowerCase() : s.toUpperCase();
        }
        
        return strArr;
    }
}