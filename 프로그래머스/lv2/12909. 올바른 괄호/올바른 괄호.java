import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            if(tmp == '(') st.push(tmp);
            else {
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        
        if(!st.isEmpty()) answer = false;

        return answer;
    }
}