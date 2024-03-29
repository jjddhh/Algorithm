import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // 처음에는 value를 Boolean으로 했다가 
        // 동명이인 케이스를 고려하여 Integer로 변경
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++) {
            map.put(participant[i], 0);
        }
        
        for(int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.get(participant[i]) + 1);
        }
        
        for(int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        String answer = "";
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while(it.hasNext()) {
            String key = it.next();
            if(map.get(key) > 0) {
                answer = key;
                break;
            };
        }
        
        return answer;
    }
}