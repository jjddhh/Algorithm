import java.util.*;

class Solution {
    public List solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int cur = 0;
        int len = progresses.length;
        while(cur < len) {
            int sum = 0;
            for(int i = cur; i < len; i++) {
                progresses[i] += speeds[i];
            }
            
            if(progresses[cur] >= 100) {
                sum++;
                cur++;
                for(int i = cur; i < len; i++) {
                    if(progresses[i] >= 100) {
                        sum++;
                        cur++;
                    } else break;
                }
                
                list.add(sum);
            }
        }
        
        // int[] answer = list.stream()
        //     .mapToInt(Integer::intValue)
        //     .toArray();
        
        return list;
    }
}