import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // dp용 배열
        int[] arr = new int[1_000_001];
        Arrays.fill(arr, -1);
        arr[x] = 0;
        
        for(int i = x; i <= y; i++) {
            if(i == x) {
                arr[i] = 0;
            } else if(i - n >= x && arr[i - n] != -1) {
                int num = getMin(arr, i);
                
                if(num == -1) {
                    arr[i] = 1 + arr[i - n];
                } else {
                    arr[i] = 1 + Math.min(arr[i - n], num);
                }
            } else {
                int num = getMin(arr, i);
                
                if(num == -1) {
                    arr[i] = -1;
                } else {
                    arr[i] = 1 + num;
                }
            }
        }
        
        return arr[y];
    }
    
    private static int getMin(int[] arr, int i) {
        if(i % 2 == 0 && arr[i / 2] != -1 && i % 3 == 0 && arr[i / 3] != -1) {
            return Math.min(arr[i / 2], arr[i / 3]);
        } else if(i % 2 == 0 && arr[i / 2] != -1) {
            return arr[i / 2];
        } else if(i % 3 == 0 && arr[i / 3] != -1) {
            return arr[i / 3];
        } else {
            return -1;
        }
        
        
    }
}