class Solution {
    public long solution(int price, int money, int count) {
        long total_count = (count * (count + 1)) / 2;
        
        long total_price = total_count * price;
        
        long answer;
        if(money - total_price >= 0) answer = 0;
        else answer = total_price - money;

        return answer;
    }
}