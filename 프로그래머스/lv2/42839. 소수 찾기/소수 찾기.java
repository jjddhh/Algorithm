class Solution {
    
    int[] num = new int[10];
    int answer = 0;
    
    public int solution(String numbers) {
        int len = numbers.length();
        for(int i = 0; i < len; i++) {
            int idx = numbers.charAt(i) - '0';
            num[idx]++;
        }
        
        for(int i = 1; i < 10; i++) {
            if(num[i] != 0) {
                num[i]--;
                solve(i);
                num[i]++;
            }
        }
        
        
        return answer;
    }
    
    public void solve(int k) {
        if(isPrime(k)) answer++;
        
        for(int i = 0; i < 10; i++) {
            if(num[i] != 0) {
                num[i]--;
                solve(k * 10 + i);
                num[i]++;
            }
        }
    }
    
    public boolean isPrime(int tmp) {
        if (tmp < 2) return false;

        for (int i = 2; i * i <= tmp; i++) {
            if (tmp % i == 0) return false;
        }
        return true;
    }
}