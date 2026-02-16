/*
다익스트라
1. list 변환
2. intensity, summit, gate 배열 생성
3. 다익스트라
*/

import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // paths -> List<List<[to, cost]>> 변환
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int[] path : paths) {
            list.get(path[0]).add(new int[] {path[1], path[2]});
            list.get(path[1]).add(new int[] {path[0], path[2]});
        }
        
        // intensity, summit, gate 배열
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        boolean[] isSummit = new boolean[n + 1];
        for (int summit : summits) isSummit[summit] = true;
        
        boolean[] isGate = new boolean[n + 1];
        for (int gate : gates) isGate[gate] = true;
        
        // 다익스트라. 출발점 모두 넣기
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.add(new int[] {gate, 0});
        }
        
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            int cur = point[0];
            int curCost = point[1];
            
            // intensity가 더 크거나, 산봉우리면 continue
            if (curCost > intensity[cur] || isSummit[cur]) continue;
            
            for (int[] nextInfo : list.get(cur)) {
                int next = nextInfo[0];
                int nextCost = nextInfo[1];
                
                // 출입구면 continue
                if (isGate[next]) continue;
                
                // 새 intensity 구하고 기존 intensity보다 작으면 추가
                int newIntensity = Math.max(curCost, nextCost);
                if (newIntensity < intensity[next]) {
                    intensity[next] = newIntensity;
                    pq.add(new int[] {next, newIntensity});
                }
            }
        }            

        // return
        Arrays.sort(summits);
        int mountain = 0;
        int minIntensity = Integer.MAX_VALUE;
        
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                mountain = summit;
                minIntensity = intensity[summit];
            }
        }
        
        return new int[] {mountain, minIntensity};
    }
}