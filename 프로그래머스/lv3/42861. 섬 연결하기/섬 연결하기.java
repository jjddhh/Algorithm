import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        boolean[] visit = new boolean[n];
        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        
        for(int i = 0; i < costs.length; i++) {
            if(costs[i][0] == 0 || costs[i][1] == 0) {
                int a = costs[i][0] == 0 ? costs[i][1] : costs[i][0];
                pq.add(new Bridge(0, a, costs[i][2]));
            }
        }
        visit[0] = true;
        
        int answer = 0;
        while(!pq.isEmpty()) {
            Bridge bridge = pq.poll();
            if(visit[bridge.i2]) continue;
            
            visit[bridge.i2] = true;
            answer += bridge.cost;
            
            for(int i = 0; i < costs.length; i++) {
                if(costs[i][0] == bridge.i2 || costs[i][1] == bridge.i2) {
                    int a, b;
                    if(costs[i][0] == bridge.i2) {
                        a = costs[i][1];
                        b = costs[i][0];
                    } else {
                        a = costs[i][0];
                        b = costs[i][1];
                    }
                    
                    if(b == bridge.i1) continue;
                    
                    pq.add(new Bridge(bridge.i2, a, costs[i][2]));
                }
            }
        }
        
        return answer;
    }
    
    class Bridge implements Comparable<Bridge>{
        int i1, i2;
        int cost;
        
        Bridge (int i1, int i2, int cost) {
            this.i1 = i1;
            this.i2 = i2;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Bridge target) {
            return this.cost - target.cost;
        }
    }
}