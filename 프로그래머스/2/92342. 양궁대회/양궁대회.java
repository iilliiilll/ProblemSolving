import java.util.*;

class Solution {
    static int[] arr = new int[11];
    static int diff = 0;
    static Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
        for(int i = 10; i >= 0; i--) {
            if(a[i] != b[i]) return Integer.compare(b[i], a[i]);
        }
        
        return 0;
    });
    
    public int[] solution(int n, int[] info) {
        dfs(n, 0, info);
        
        if(pq.isEmpty()) return new int[] {-1};
        return pq.poll();
    }
    
    private static void dfs(int n, int idx, int[] info) {
        if(idx == 10) {
            arr[idx] = n; // 남은 화살 0점에 몰아주기
            isWin(info); // 라이언이 이겼는지 (info, arr 비교)
            arr[idx] = 0;
            return;
        }
        
        // 1. 어피치 승
        dfs(n, idx + 1, info);
        
        // 2. 라이언 승
        int num = info[idx] + 1;
        
        if(n >= num) {
            arr[idx] += num;
            dfs(n - num, idx + 1, info);
            arr[idx] = 0;
        }
    }
    
    private static void isWin(int[] info) {
        int scoreA = 0; // 라이언
        int scoreB = 0; // 어피치
        
        for(int i = 0; i < 11; i++) {
            if(info[i] == 0 && arr[i] == 0) continue;
            else if(arr[i] <= info[i]) scoreB += 10 - i;
            else scoreA += 10 - i;
        }
        
        if(scoreA > scoreB) {
            if(scoreA - scoreB > diff) {
                diff = scoreA - scoreB;
                pq.clear();
                pq.add(Arrays.copyOf(arr, 11));
            } else if(scoreA - scoreB == diff) {
                pq.add(Arrays.copyOf(arr, 11));
            }
        }
    }
}