import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            int val = Integer.parseInt(op[1]);
            
            if(op[0].equals("I")) {
                min.add(val);
                max.add(val);
            } else {
                if(min.isEmpty()) continue;
                
                if(val > 0) min.remove(max.poll());
                else max.remove(min.poll());
            }
        }
        
        int[] answer = new int[2];
        int size = min.size();
        
        if(size == 0) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}