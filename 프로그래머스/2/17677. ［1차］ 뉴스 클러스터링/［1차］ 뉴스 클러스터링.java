import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = makeList(str1);
        List<String> list2 = makeList(str2);
        
        if(list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }
        
        int both = 0;
        for(String s : list1) {
            if(list2.contains(s)) {
                both++;
                list2.remove(s);
            }
        }
        
        int sum = list1.size() + list2.size();
        
        double answer = (double) both / sum;
        return (int) (answer * 65536);
    }
    
    private static List<String> makeList(String str) {
        List<String> list = new ArrayList<>();
        char[] arr = str.toUpperCase().toCharArray();
        
        for(int i = 0; i < arr.length - 1; i++) {
            char c1 = arr[i];
            char c2 = arr[i + 1];
            
            if(Character.isLetter(c1) && Character.isLetter(c2)) {
                String temp = String.valueOf(c1) + String.valueOf(c2);
                list.add(temp);
            }
        }
        
        return list;
    }
}