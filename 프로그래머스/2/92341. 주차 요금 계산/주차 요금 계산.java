import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
//         // 차량번호, 사용시간
//         Map<Integer, Integer> map = new HashMap<>();
        
//         // [차량번호, 요금] - 차량번호 오름차순
//         Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
//             return Integer.compare(a[0], b[0]);
//         });
        
//         // records 순회하며 map에 넣기
//         for(String record : records) {
//             StringTokenizer st = new StringTokenizer(record);
            
//             // 시간, 차량번호, 입출차
//             String temp = st.nextToken();
//             int time = 60 * Integer.parseInt(temp.substring(0, 2)) + Integer.parseInt(temp.substring(3, 5));
//             int number = Integer.parseInt(st.nextToken());
//             time = st.nextToken().length() == 2 ? -time : time;

//             // map에 넣기
//             map.put(number, map.getOrDefault(number, 0) + time);
//         }
        
//         // map 순회하며 pq에 넣기
//         for(int num : map.keySet()) {
//             int totalTime = map.get(num);
            
//             // 출차가 없다면 더하기
//             if(totalTime <= 0) {
//                 totalTime += 1439;
//             }
            
//             // 요금 계산
//             int fee = fees[1];
            
//             if(totalTime > fees[0]) {
//                 fee += (int) Math.ceil((totalTime - fees[0]) / (double) fees[2]) * fees[3];
//             }
            
//             pq.add(new int[]{num, fee});
//         }
        
//         // pq 순회하면서 배열 만들고 return
//         int[] answer = new int[pq.size()];
//         for(int i = 0; i < answer.length; i++) {
//             answer[i] = pq.poll()[1];
//         }
//         return answer;
        
        // 차량번호, 사용시간
        Map<Integer, Integer> map = new TreeMap<>();
        
        // records 순회하며 map에 넣기
        for(String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            
            // 시간, 차량번호, 입출차
            String temp = st.nextToken();
            int time = 60 * Integer.parseInt(temp.substring(0, 2)) + Integer.parseInt(temp.substring(3, 5));
            int number = Integer.parseInt(st.nextToken());
            time = st.nextToken().length() == 2 ? -time : time;

            // map에 넣기
            map.put(number, map.getOrDefault(number, 0) + time);
        }
        
        // 요금 계산
        int[] answer = new int[map.size()];
        int idx = 0;
        
        for(int t : map.values()) {
            // 출차가 없다면 더하기
            if(t <= 0) {
                t += 1439;
            }
            
            // 요금 계산
            int f = fees[1];
            
            if(t > fees[0]) {
                f += (int) Math.ceil((t - fees[0]) / (double) fees[2]) * fees[3];
            }
            
            answer[idx++] = f;
        }

        return answer;
    }
}