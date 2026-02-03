import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        Set<String> set = new HashSet<>();
        
        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int struct = frame[2];
            boolean install = frame[3] == 0 ? false : true;
            
            // 설치할 수 있으면 set에 추가, 삭제할 수 있으면 set에서 제거
            if (install) {
                if (struct == 0 && canInstall(set, n, x, y, struct)) {
                    set.add(x + "," + y + ",0");
                } else if (struct == 1 && canInstall(set, n, x, y, struct)) {
                    set.add(x + "," + y + ",1");
                }
            } else {
                if (struct == 0) {
                    Set<String> temp = new HashSet<>(set);
                    temp.remove(x + "," + y + ",0");
                    if (possible(temp, n)) set.remove(x + "," + y + ",0");
                } else if (struct == 1) {
                    Set<String> temp = new HashSet<>(set);
                    temp.remove(x + "," + y + ",1");
                    if (possible(temp, n)) set.remove(x + "," + y + ",1");
                }
            }
        }
        
        // return
        List<String> list = new ArrayList<>(set);
        list.sort((a, b) -> {
            StringTokenizer st = new StringTokenizer(a, ",");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int st1 = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(b, ",");
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int st2 = Integer.parseInt(st.nextToken());
            
            if (x1 != x2) return x1 - x2;
            else if (y1 != y2) return y1 - y2;
            else return st1 - st2;
        });
        
        int[][] answer = new int[list.size()][3];
        for(int i = 0; i < answer.length; i++) {
            StringTokenizer st = new StringTokenizer(list.get(i), ",");
            answer[i][0] = Integer.parseInt(st.nextToken());
            answer[i][1] = Integer.parseInt(st.nextToken());
            answer[i][2] = Integer.parseInt(st.nextToken());
        }
        
        return answer;
    }

    
    static boolean canInstall(Set<String> set, int n, int x, int y, int struct) {
        if (struct == 0) {
            // 바닥 위
            if (y == 0) return true;
            
            // 다른 기둥 위
            int nx = x;
            int ny = y - 1;
            if (ny >= 0 && set.contains(nx + "," + ny + ",0")) return true;
            
            // 보의 한쪽 끝 부분 위
            if (set.contains(x + "," + y + ",1") || (x - 1 >= 0 && set.contains((x - 1) + "," + y + ",1"))) return true;
        } else {
            // 한쪽 끝 부분이 기둥 위
            if (set.contains(x + "," + (y - 1) + ",0") || set.contains((x + 1) + "," + (y - 1) + ",0")) return true;
            
            // 양쪽 끝 부분이 다른 보와 동시에 연결
            if (set.contains((x - 1) + "," + y + ",1") && set.contains((x + 1) + "," + y + ",1")) return true;
        }
        
        return false;
    }
    
    static boolean possible(Set<String> temp, int n) {
        for (String t : temp) {
            StringTokenizer st = new StringTokenizer(t, ",");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int struct = Integer.parseInt(st.nextToken());
            
            if (!canInstall(temp, n, x, y, struct)) {
                return false;
            }
        }
        
        return true;
    }
}