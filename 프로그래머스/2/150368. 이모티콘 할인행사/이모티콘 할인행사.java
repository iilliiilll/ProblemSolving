class Solution {
    static int totalPlus = 0;
    static int totalPrice = 0;
    static int[] dc;
    static int[] sales = new int[] {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        // dfs
        dc = new int[emoticons.length];
        discount(users, emoticons, 0);
        
        return new int[] {totalPlus, totalPrice};
    }
    
    private static void discount(int[][] users, int[] emoticons, int count) {
        if(count == emoticons.length) {
            cal(users, emoticons);
            return;
        }
        
        for(int sale : sales) {
            dc[count] = sale;
            discount(users, emoticons, count + 1);
        }
    }
    
    private static void cal(int[][] users, int[] emoticons) {
        // 가입자, 판매액
        int plus = 0;
        int price = 0;
        
        for(int[] user : users) {
            int userDc = user[0];
            int userPrice = user[1];
            int sum = 0;
            
            for(int i = 0; i < emoticons.length; i++) {
                    if(userDc <= dc[i]) sum += emoticons[i] * (100 - dc[i]) / 100;
            }
            
            if(sum >= userPrice) plus++;
            else price += sum;
        }
        
        if(totalPlus < plus) {
            totalPlus = plus;
            totalPrice = price;
        } else if(totalPlus == plus) {
            if(totalPrice < price) totalPrice = price;
        }
    }
}