class Solution {
    
    String[] alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    public int solution(String s) {
        
        String ans = "";
        int len = s.length();
        for(int i = 0; i < len; i++) {
            boolean flag = false;
            for(int j = 0; j < 10; j++) {
                if(s.charAt(i) == num[j]) {
                    flag = true;
                    ans += num[j];
                    // i++;
                    break;
                }
            }
            if(flag) continue;
            
            String sub = s.substring(i);
            for(int j = 0; j < 10; j++) {
                if(sub.startsWith(alpha[j])) {
                    ans += j;
                    // i += alpha[j].length();
                    break;
                }
            }
            
        }
        
        int answer = Integer.parseInt(ans);
        return answer;
    }
}