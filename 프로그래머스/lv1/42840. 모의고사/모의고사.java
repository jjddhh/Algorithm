import java.util.*;

class Solution {
    
    int[] fir = {1, 2, 3, 4, 5};
    int[] sec = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] trd = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public List solution(int[] answers) {
        
        int fir_ans = 0;
        int sec_ans = 0;
        int trd_ans = 0;
        for(int i = 0; i < answers.length; i++) {
            if(fir[i % 5] == answers[i]) fir_ans++;
            if(sec[i % 8] == answers[i]) sec_ans++;
            if(trd[i % 10] == answers[i]) trd_ans++;
        }
        
        List<Integer> list = new ArrayList<>();
        int max = Math.max(fir_ans, Math.max(sec_ans, trd_ans));
        if(fir_ans == max) list.add(1);
        if(sec_ans == max) list.add(2);
        if(trd_ans == max) list.add(3);
        
        return list;
    }
}