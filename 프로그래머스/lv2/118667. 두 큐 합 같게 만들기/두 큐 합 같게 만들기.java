import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        long qu1Sum = 0;
        long qu2Sum = 0;
        for(int i = 0; i < queue1.length; i++) {
            qu1.add(queue1[i]);
            qu2.add(queue2[i]);
            qu1Sum += queue1[i];
            qu2Sum += queue2[i];
        }
        
        int cnt = 0;
        int len = queue1.length * 4;
        for(int i = 0; i < len; i++) {
            if(qu1Sum == qu2Sum) break;
            else if(qu1Sum > qu2Sum) {
                int elem = qu1.poll();
                qu2.add(elem);
                qu1Sum -= elem;
                qu2Sum += elem;
            } else {
                int elem = qu2.poll();
                qu1.add(elem);
                qu2Sum -= elem;
                qu1Sum += elem;
            }
            
            cnt++;
        }
        
        int answer = -1;
        if(cnt != len) answer = cnt;
        return answer;
    }
}