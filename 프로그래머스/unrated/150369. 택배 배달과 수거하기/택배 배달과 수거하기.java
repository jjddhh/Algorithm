// 처음에 deliveries, pickcups 의 원소 <= cap 인줄 알고 while 없이 if만 돌림
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int delivery = 0;
        int pickup = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(delivery - deliveries[i] < 0 || pickup - pickups[i] < 0) {
                delivery += cap;
                pickup += cap;
                answer += i + 1;
            }
            delivery -= deliveries[i];
            pickup -= pickups[i];
        }
        
        // 오고 가고
        answer *= 2;
        
        return answer;
    }
}