import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // adj list
        int answer = -1;
        List<Integer>[] list = new List[n + 1];
        for(int i = 1; i <= wires.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++) {
            List<Integer> adj = list[wires[i][0]];
            adj.add(wires[i][1]);
        }
        
        
        for(int i = 0; i < wires.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int chain = 1;
            int cut = wires[i][1];
            boolean[] visit = new boolean[n + 1];
            
            visit[wires[i][0]] = true;
            queue.add(wires[i][0]);
            
            while(!queue.isEmpty()) {
                int node = queue.poll();
                List<Integer> next = list[node];

                for(int j = 0; j < next.size(); j++) {
                    int t = next.get(j);
                    if(visit[t] || t == cut) continue;
                    visit[t] = true;
                    queue.add(t);
                    chain++;
                } 
            }
            
            answer = Math.max(answer, Math.abs((n - chain) - chain));
            
        }
        
        return answer;
    }
}