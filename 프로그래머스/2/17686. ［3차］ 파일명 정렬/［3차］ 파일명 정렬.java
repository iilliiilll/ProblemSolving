import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // [파일명, 삽입순서]
        Queue<String[]> pq = new PriorityQueue<>((a, b) -> {
            int a1 = Integer.parseInt(a[1]);
            int b1 = Integer.parseInt(b[1]);
            int a2 = Integer.parseInt(a[2]);
            int b2 = Integer.parseInt(b[2]);
            
            if(!a[0].equals(b[0])) {
                return a[0].compareTo(b[0]);
            } else if(a1 != b1) {
                return Integer.compare(a1, b1);
            } else {
                return Integer.compare(a2, b2);
            }
        });
        
        StringBuilder sb1, sb2;
        // files 순회하며 pq에 삽입
        for(int i = 0; i < files.length; i++) {
            sb1 = new StringBuilder();
            sb2 = new StringBuilder();
            
            // head, number 분리
            char[] arr = files[i].toCharArray();
            int idx = 0;
            
            while(!Character.isDigit(arr[idx])) {
                sb1.append(arr[idx++]);
            }
            
            while(idx < arr.length && sb2.length() <= 5 && Character.isDigit(arr[idx])) {
                sb2.append(arr[idx++]);
            }
            
            pq.add(new String[] {sb1.toString().toUpperCase(), sb2.toString(), String.valueOf(i)});
        }
        
        // return
        String[] answer = new String[pq.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = files[Integer.parseInt(pq.poll()[2])];
        }
        
        return answer;
    }
}