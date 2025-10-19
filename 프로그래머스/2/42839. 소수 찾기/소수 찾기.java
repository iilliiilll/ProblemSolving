import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        // 모든 문자열 탐색하면서 HashSet에 넣기
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        
        dfs(arr, visited, "");
        
        // HashSet 순회하면서 소수인지 판별
        int answer = 0;
        
        for(int n : set) {
            if(isPrime(n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(char[] arr, boolean[] visited, String number) {
        if(number.length() != 0) {
            set.add(Integer.parseInt(number));
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(arr, visited, number + arr[i]);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}