import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('A', 0);
        hash.put('N', 0);
        hash.put('C', 0);
        hash.put('F', 0);
        hash.put('M', 0);
        hash.put('J', 0);
        hash.put('R', 0);
        hash.put('T', 0);
        
        int len = survey.length;
        for(int i = 0; i < len; i++) {
            int score = choices[i] - 4;
            if(score < 0) {
                Character a = survey[i].charAt(0);
                hash.put(a, hash.get(a) + (score * -1));
            } else if (score > 0) {
                Character b = survey[i].charAt(1);
                hash.put(b, hash.get(b) + score);
            }
        }
        
        String answer = "";
        answer += hash.get('R') < hash.get('T') ? "T" : "R";
        answer += hash.get('C') < hash.get('F') ? "F" : "C";
        answer += hash.get('J') < hash.get('M') ? "M" : "J";
        answer += hash.get('A') < hash.get('N') ? "N" : "A";
        
        return answer;
    }
}