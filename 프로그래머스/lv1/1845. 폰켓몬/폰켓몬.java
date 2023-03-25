import java.util.*;

class Solution {
    
    boolean isVisit[] = new boolean[10001];
    
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean type[] = new boolean[200001];
        for(int i = 0; i < nums.length; i++) {
            if(!type[nums[i]]) {
                answer++;
                type[nums[i]] = true;
            }
        }
        
        if(answer > (nums.length / 2)) answer = nums.length / 2;
        
        return answer;
    }
}