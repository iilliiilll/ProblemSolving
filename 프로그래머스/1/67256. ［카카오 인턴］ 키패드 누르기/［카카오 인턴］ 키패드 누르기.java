class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for(int number : numbers) {
            if(number % 3 == 1) {
                left = new int[] { number / 3, 0 };
                sb.append("L");
            } else if(number == 0 || number % 3 == 2) {
                int[] d = getDistance(number, left, right);
                
                if(d[0] == -1 || (d[0] == 0 && hand.equals("left"))) {
                    left = new int[] { d[1], 1 };
                    sb.append("L");
                } else if(d[0] == 1 || (d[0] == 0 && hand.equals("right"))) {
                    right = new int[] { d[1], 1 };
                    sb.append("R");
                }
            } else {
                right = new int[] { (number - 1) / 3, 2 };
                sb.append("R");
            }
        }
        
        return sb.toString();
    }
    
    private static int[] getDistance(int number, int[] left, int[] right) {
        int[] answer = {0, 0, 1};
        int ld, rd;
        int l1 = Math.abs(left[1] - 1);
        int r1 = Math.abs(right[1] - 1);
        
        if(number == 2) {
            ld = Math.abs(left[0] - 0) + l1;
            rd = Math.abs(right[0] - 0) + r1;
            answer[1] = 0;
        } else if(number == 5) {
            ld = Math.abs(left[0] - 1) + l1;
            rd = Math.abs(right[0] - 1) + r1;
            answer[1] = 1;
        } else if(number == 8) {
            ld = Math.abs(left[0] - 2) + l1;
            rd = Math.abs(right[0] - 2) + r1;
            answer[1] = 2;
        } else {
            ld = Math.abs(left[0] - 3) + l1;
            rd = Math.abs(right[0] - 3) + r1;
            answer[1] = 3;
        }
        
        if(ld < rd) {
            answer[0] = -1;
        } else if(ld > rd) {
            answer[0] = 1;
        } else {
            answer[0] = 0;
        }
        
        return answer;
    }
}