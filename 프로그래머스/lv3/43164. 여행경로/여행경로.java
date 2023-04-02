import java.util.*;

class Solution {
    List<String> answer;
    boolean[] visit = new boolean[10001];
    List<Ticket> list = new ArrayList<>();
    int max = 0;
    
    public List solution(String[][] tickets) {
        
        for(int i = 0; i < tickets.length; i++) {
            list.add(new Ticket(tickets[i][0], tickets[i][1]));
        }
        Collections.sort(list);
        
        for(int i = 0; i < tickets.length; i++) {
            if(list.get(i).from.compareTo("ICN") == 0) {
                visit[i] = true;
                dfs(new ArrayList<>(Arrays.asList("ICN", list.get(i).to)), list.get(i).to);
                visit[i] = false;
            }
        }
        
        return answer;
    }
    
    void dfs(List<String> his, String cur) {
        int size = his.size();
        if(max < size) {
            answer = new ArrayList<>(his);
            max = size;
        }
        
        int list_size = list.size();
        for (int i = 0; i < list_size; i++) {
            if(visit[i]) continue;
            if(list.get(i).from.compareTo(cur) != 0) continue;
            visit[i] = true;
            his.add(list.get(i).to);

            dfs(his, list.get(i).to);

            his.remove(his.size() - 1);
            visit[i] = false;
        }
        
    }
    
    class Ticket implements Comparable<Ticket>{
        String from, to;
        
        Ticket (String from, String to) {
            this.from = from;
            this.to = to;
        }
        
        @Override
        public int compareTo(Ticket target) {
            return to.compareTo(target.to);
        }
    }
}