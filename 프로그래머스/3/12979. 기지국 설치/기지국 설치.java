class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        
        // start와 station 사이에 설치할 수 있는 기지국 개수
        for(int station : stations) {
            if (start < station - w) answer += getCount(start, station - w - 1, w);
            start = station + w + 1;
        }
        
        if (start <= n) answer += getCount(start, n, w);

        return answer;
    }
    
    private static int getCount(int start, int station, int w) {
        int len = station - start + 1;
        int dist = 2 * w + 1;
        
        return len % dist != 0 ? len / dist + 1 : len / dist;
    }
}