class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dPoint = n - 1;
        int pPoint = n - 1;

        // 모두 빌 때까지 반복
        while(dPoint >= 0 || pPoint >= 0) {
            // 0은 모두 빼기
            while(dPoint >= 0 && deliveries[dPoint] == 0) dPoint--;
            while(pPoint >= 0 && pickups[pPoint] == 0) pPoint--;
            
            if(dPoint < 0 && pPoint < 0) break;

            // 마지막 집의 거리의 최댓값까지 가야함
            answer += Math.max(dPoint, pPoint) + 1;

            // cap개 배달, 수거
            int d = cap;
            while(dPoint >= 0 && d > 0) {
                if(deliveries[dPoint] > d) {
                    deliveries[dPoint] -= d;
                    d = 0;
                } else {
                    d -= deliveries[dPoint--];
                }
            }

            int p = cap;
            while(pPoint >= 0 && p > 0) {
                if(pickups[pPoint] > p) {
                    pickups[pPoint] -= p;
                    p = 0;
                } else {
                    p -= pickups[pPoint--];
                }
            }
        }
        
        return answer * 2;
    }
}