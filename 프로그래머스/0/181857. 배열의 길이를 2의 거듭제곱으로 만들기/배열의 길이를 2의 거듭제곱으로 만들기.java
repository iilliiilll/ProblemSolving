class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        
        for(int i = 0; i <= 10; i++) {
            int two = (int) Math.pow(2, i);
            
            if(len < two) {
                len = two;
                break;
            } else if(len == two) {
                break;
            }
        }
        
        int[] answer = new int[len];
        
        for(int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        
        return answer;
    }
}