/*
1. weak.length * 2 길이의 배열 생성
2. dist 역순정렬 (큰 수부터 탐색)
3. 순열 생성
4. 생성한 순열이 취약지점을 모두 커버하는지 체크
*/

import java.util.*;

class Solution {
    int answer = -1;
    int wLen;
    int[] wArr;
    
    public int solution(int n, int[] weak, int[] dist) {
        // weak 길이 2배의 배열
        wLen = weak.length;
        wArr = new int[wLen * 2];
        
        for (int i = 0; i < wLen; i++) {
            wArr[i] = weak[i];
            wArr[i + wLen] = weak[i] + n;
        }
        
        // dist 역순정렬
        Arrays.sort(dist);
        for (int i = 0; i < dist.length / 2; i++) {
            int temp = dist[i];
            dist[i] = dist[dist.length - 1 - i];
            dist[dist.length - 1 - i] = temp;
        }
        
        for (int cnt = 1; cnt <= dist.length; cnt++) { // 순열 만들기 (1명부터 시작)
            for (int start = 0; start < wLen; start++) { // 시작 인덱스 설정 (0부터 시작)
                List<Integer> perm = new ArrayList<>();
                makePermutaion(dist, cnt, start, new boolean[dist.length], perm);

                if (answer != -1) return answer;
            }
        }
        
        return answer;
    }
    
    private void makePermutaion(int[] dist, int cnt, int start, boolean[] used, List<Integer> perm) {
        if (perm.size() == cnt) {
            if (check(start, perm)) answer = perm.size();
            return;
        }
        
        for (int i = 0; i < dist.length; i++) {
            if (used[i]) continue;
            
            used[i] = true;
            perm.add(dist[i]);
            
            makePermutaion(dist, cnt, start, used, perm);
            
            used[i] = false;
            perm.remove(perm.size() - 1);
        }
    }
    
    private boolean check (int start, List<Integer> perm) {
        int idx = start;
        int end = start + wLen;
        
        for (int p : perm) {
            int limit = wArr[idx] + p;
            while (idx < end && wArr[idx] <= limit) idx++;
            
            if (idx >= end) return true;
        }
        
        return false;
    }
}