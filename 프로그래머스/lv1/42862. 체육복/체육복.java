import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] brw = new boolean[n + 1];
        for(int i = 0; i < reserve.length; i++) {
             brw[reserve[i]] = true;
        }
        
        int answer = n - lost.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < lost.length; i++) {
            boolean flag = true;
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    brw[reserve[j]] = false;
                    answer++;
                    flag = false;
                    break;
                }
            }
            
            if(flag) list.add(lost[i]);
        }
        
        int len = list.size();
        
        for(int i = 0; i < len; i++) {
            int student = list.get(i);
            if(student > 1 && brw[student - 1]) {
                answer++;
                brw[student - 1] = false;
            } else if (student < n && brw[student + 1]) {
                answer++;
                brw[student + 1] = false;
            }
        }
        
        return answer;
    }
}