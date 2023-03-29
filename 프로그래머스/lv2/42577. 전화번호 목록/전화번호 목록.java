import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], true);
        }
        
        boolean answer = true;
        for(int i = 0; i < phone_book.length; i++) {
            int len = phone_book[i].length();
            for(int j = 1; j <= len - 1; j++) {
                String prefix = phone_book[i].substring(0, j);
                if(map.get(prefix) != null) {
                    answer = false;
                    break;
                }
            }
            if(!answer) break;
        }
        
        return answer;
    }
}