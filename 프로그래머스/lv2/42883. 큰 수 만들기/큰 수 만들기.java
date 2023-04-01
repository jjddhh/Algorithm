class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int cur_idx = 0;
        int next = 0;
        
        for(int i = 0; i < len - k; i++) {
            int max = 0;
            
            
            for(int j = cur_idx; j <= i + k; j++) {
                int num = number.charAt(j) - '0';
                if(max < num) {
                    max = num;
                    next = j;
                }
            }
            
            answer.append(max);
            cur_idx = next + 1;
        }
        
        return answer.toString();
    }
}