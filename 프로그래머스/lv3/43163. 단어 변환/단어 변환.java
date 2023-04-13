import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int word_len = begin.length();
        boolean[] visit = new boolean[words.length];
        Queue<Word> que = new LinkedList<>();
        que.add(new Word(begin, 0));
        
        int answer = 0;
        while(!que.isEmpty()) {
            Word cur = que.poll();
            if(cur.w.compareTo(target) == 0) {
                answer = cur.t;
                break;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(visit[i]) continue;
                
                int cnt = 0;
                for(int j = 0; j < word_len; j++) {
                    Character a = cur.w.charAt(j);
                    Character b = words[i].charAt(j);
                    if(a.compareTo(b) != 0) cnt++;
                }
                
                // 두 단어 비교했을때, 다른 알파벳이 1개 일 경우
                if(cnt == 1) {
                    visit[i] = true;
                    que.add(new Word(words[i], cur.t + 1));
                }
            }
        }
        
        return answer;
    }
    
    class Word {
        String w;
        int t;
        
        Word (String w, int t) {
            this.w = w;
            this.t = t;
        }
    }
}