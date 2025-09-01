class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            sb.append(String.valueOf(i).repeat(food[i] / 2));
        }
        
        StringBuilder temp = new StringBuilder(sb.toString());
        temp.reverse();
        
        return sb.append(0).append(temp.toString()).toString();
    }
}