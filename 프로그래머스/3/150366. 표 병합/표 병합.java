/*
union-find
1. parent, value 배열 생성
2. UPDATE 1: 루트 찾아서 값 변경
3. UPDATE 2: 순회하면서 from->to 변경
3. MERGE: 루트가 r2인 좌표를 모두 r1으로 변경. r1, r2 값 중 선택. r2 값은 null. 
4. UNMERGE: 인덱스, 루트, 값 저장. 부모가 루트는 모두 null 변환. 인덱스에 값 저장. 
*/

import java.util.*;

class Solution {
    int[] parent = new int[2501];
    String[] value = new String[2501];
    
    public String[] solution(String[] commands) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 2500; i++) parent[i] = i;
        
        for (String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            int count = st.countTokens();
            String cmd = st.nextToken();
            
            switch (cmd) {
                    case "UPDATE" -> {
                        if (count == 4) {
                            int root = find(convert(st.nextToken(), st.nextToken()));
                            value[root] = st.nextToken();
                        } else {
                            String from = st.nextToken();
                            String to = st.nextToken();
                            
                            for (int i = 1; i <= 2500; i++) {
                                int root = find(i);
                                if (value[root] != null && value[root].equals(from)) value[root] = to;
                            }
                        }
                    }
                    case "MERGE" -> {
                        int r1 = find(convert(st.nextToken(), st.nextToken()));
                        int r2 = find(convert(st.nextToken(), st.nextToken()));
                        
                        if (r1 != r2) {
                            for (int i = 1; i <= 2500; i++) {
                                if (find(i) == r2) parent[i] = r1;
                            }
                            
                            if (value[r1] == null) value[r1] = value[r2];
                            value[r2] = null;
                        }
                    }
                    case "UNMERGE" -> {
                        int idx = convert(st.nextToken(), st.nextToken());
                        int root = find(idx);
                        String saved = value[root];
                        
                        for (int i = 1; i <= 2500; i++) {
                            if (find(i) == root) {
                                parent[i] = i;
                                value[i] = null;
                            }
                        }
                        
                        value[idx] = saved;
                    }
                    case "PRINT" -> {
                        int root = find(convert(st.nextToken(), st.nextToken()));
                        list.add(value[root] == null ? "EMPTY" : value[root]);
                    }
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
    
    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    int convert(String r, String c) {
        return (Integer.parseInt(r) - 1) * 50 + Integer.parseInt(c);
    }
}