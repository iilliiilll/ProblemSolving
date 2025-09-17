class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        // 공격
        int hp = health - attacks[0][1];
        if(hp <= 0) {
            return -1;
        }
        
        for(int i = 1; i < attacks.length; i++) {
            // 회복
            int duringTime = attacks[i][0] - attacks[i - 1][0] - 1;
            hp += duringTime * x + (duringTime / time) * y;
            hp = Math.min(hp, health);
            
            // 공격
            hp -= attacks[i][1];
            if(hp <= 0) {
                return -1;
            }
        }
        
        return hp == 0 ? -1 : hp;
    }
}