import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    // public List solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int cur = 0;
        int len = progresses.length;
        while(cur < len) {
            int sum = 0;
            for(int i = cur; i < len; i++) {
                progresses[i] += speeds[i];
            }
            
            // 현재 작업 진도가 100 이상일 때,
            // 그 뒤 작업들 중 진도가 100 이상인 것들을 연속으로 체크
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
        
        //스트림 효율 관련 내용
        int[] answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}