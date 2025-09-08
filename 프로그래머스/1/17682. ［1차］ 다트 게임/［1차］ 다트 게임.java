class Solution {
    public int solution(String dartResult) {
        StringBuilder sb = new StringBuilder();
        int[] score = new int[5];
        char[] ch_arr = dartResult.toCharArray();
        
        int idx = 1;
        for(int i = 0; i < ch_arr.length; i++) {
            if('0' <= ch_arr[i] && ch_arr[i] <= '9') {
                if(ch_arr[i + 1] == '0') {
                    score[idx++] = 10;
                    i++;
                } else {
                    score[idx++] = ch_arr[i] - '0';
                }
            }
        }
        
        idx = 1;
        for(int i = 0; i < ch_arr.length; i++) {
            int s = score[idx];
            
            if(ch_arr[i] == 'S') {
                score[idx++] = s;
            } else if(ch_arr[i] == 'D') {
                score[idx++] = (int) Math.pow(s, 2);
            } else if(ch_arr[i] == 'T') {
                score[idx++] = (int) Math.pow(s, 3);
            }
            
            if(i + 1 < ch_arr.length && ch_arr[i + 1] == '*') {
                score[idx - 2] *= 2;
                score[idx - 1] *= 2;
            } else if(i + 1 < ch_arr.length && ch_arr[i + 1] == '#') {
                score[idx - 1] *= -1;
            }
        }
        
        return score[1] + score[2] + score[3];
    }
}