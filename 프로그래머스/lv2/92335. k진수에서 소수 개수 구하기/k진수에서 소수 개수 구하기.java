class Solution {
    public int solution(int n, int k) {
        String convert = "";
        while(n != 0) {
            convert = (n % k) + convert;
            n = n / k;
        }
        
        int answer = 0;
        int len = convert.length();
        int begin = 0;
        for(int i = 0; i < len; i++) {
            String temp = "";
            
            if(convert.charAt(i) != '0') {
                while(i < len && convert.charAt(i) != '0') {
                    temp = temp + convert.charAt(i);      
                    i++;
                }
                
                long num = Long.valueOf(temp);
                // System.out.println(num);
                if(isPrime(num)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
     public boolean isPrime(long num) {
        if(num == 1L) {
            return false;
        } else if(num == 2L) {
            return true;
        }

        int limit = (int) Math.sqrt(num);
        for(int i = 2; i <= limit; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}