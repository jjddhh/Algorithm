import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            if(map.get(type) != null) map.put(type, map.get(type) + 1);
            else map.put(type, 1); 
        }
        
        int answer = 1;
        Iterator<String> it = map.keySet().iterator();        
        while(it.hasNext()) {
            String type = it.next();
            int cnt = map.get(type);
            answer = answer * (cnt + 1);
        }
        
        // 아무것도 입지 않는 경우
        answer--;
        
        return answer;
    }
}