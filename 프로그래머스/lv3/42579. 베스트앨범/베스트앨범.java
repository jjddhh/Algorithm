import java.util.*;
import java.util.Map.Entry;

class Solution {
    public List solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalMap = new HashMap<>();
        HashMap<String, List<Music>> idxMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            if(totalMap.get(genres[i]) == null) totalMap.put(genres[i], plays[i]);
            else totalMap.put(genres[i], totalMap.get(genres[i]) + plays[i]);
            
            if(idxMap.get(genres[i]) == null) {
                List<Music> list = new ArrayList<>();
                list.add(new Music(i, plays[i]));
                idxMap.put(genres[i], list);
            } else {
                idxMap.get(genres[i]).add(new Music(i, plays[i]));
            }
        }
        
        List<Entry<String, Integer>> list_entries = new ArrayList<>(totalMap.entrySet());
        Collections.sort(list_entries, (o1, o2) -> o2.getValue() - o1.getValue());
        
        // int[] answer = {};
        List<Integer> answer = new ArrayList<>();
        for(Entry<String, Integer> entry : list_entries) {
			List<Music> list = idxMap.get(entry.getKey());
            Collections.sort(list);
            int cnt = 1;
            if(list.size() >= 2) cnt = 2;
            for(int i = 0; i < cnt; i++) {
                answer.add(list.get(i).idx);
            }
		}
        
        return answer;
    }
    
    class Music implements Comparable<Music>{
        int idx;
        int play;
        
        Music (int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music target) {
            if(target.play - play == 0) return idx - target.idx;
            return target.play - play;
        }
    }
}