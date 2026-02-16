/*
1. 배열 원소 카운트 후 hashmap에 저장
2. map 순회하면서 스타배열의 길이 구하기
3. 최댓값이 현재 답보다 같거나 작으면 가지치기
4. 값 두 개씩 비교, 조건 만족 시 다음 인덱스로 이동
*/

import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        // a의 원소 카운트
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) map.put(num, map.getOrDefault(num, 0) + 1);
        
        // 현재 i와 맞는 key 찾기
        for (int key : map.keySet()) {
            if (map.get(key) * 2 <= answer) continue;
            answer = Math.max(answer, isStar(a, key));
        }
        
        return answer;
    }
    
    private int isStar (int[] a, int num) {
        int count = 0;
        
        for (int i = 0; i < a.length - 1; i++) {
            if ((a[i] == num || a[i+1] == num) && a[i] != a[i+1]) {
                i++;
                count++;
            }
        }
        
        return count * 2;
    }
}