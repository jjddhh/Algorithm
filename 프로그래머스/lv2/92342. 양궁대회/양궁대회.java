import java.util.*;

class Solution {
    int max = 0;
    int[] result = new int[11];
    int[] answer = new int[11];
    
    public int[] solution(int n, int[] info) {
        
        bt(0, n, info);
        
        System.out.println(max);
        if(max > 0) return answer;
        else return new int[]{-1};
    }
    
    public void bt(int depth, int left, int[] info) {
        if(depth == 10) {
            result[10] = left;
            int sum = 0;
            for(int i = 0; i <= 10; i++) {
                if(info[i] < result[i]) sum += (10 - i);
                else if(info[i] > 0 && info[i] >= result[i]) sum -= (10 - i);
            }
            
            if(sum > max) {
                max = sum;
                answer = Arrays.copyOf(result, result.length);
            } else if (sum == max) {
                for(int k = 10; k >= 0; k--) {
                    if(answer[k] < result[k]) {
                        answer = Arrays.copyOf(result, result.length);
                        break;
                    } else if (answer[k] > result[k]) {
                        break;
                    }
                }
            }
            
            return;
        }
        
        for(int i = 0; i <= left; i++) {
            result[depth] = i;
            bt(depth + 1, left - i, info);
        }
    }
}