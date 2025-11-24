import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int max = 0;

        // 배열 크기 구하기
        for(int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1]));
        }
        
        int[] in = new int[max + 1];
        int[] out = new int[max + 1];

        // in, out 배열 생성
        for(int[] edge : edges) {
            out[edge[0]]++;
            in[edge[1]]++;
        }
        
        int newNode = 0;
        int eight = 0;
        int stick = 0;
        
        // 그래프의 마지막 노드 비교
        for(int i = 1; i <= max; i++) {
            if(out[i] >= 2 && in[i] == 0) { // in은 없고, out만 있을 때
                newNode = i;
            } else if(out[i] >= 2 && in[i] >= 2) { // in, out 모두 2 이상일 때
                eight++;
            } else if(out[i] == 0 && in[i] > 0) { // in은 있고, out은 없을 때
                stick++;
            }
        }
        
        return new int[] {newNode, out[newNode] - eight - stick, stick, eight};
    }
}
