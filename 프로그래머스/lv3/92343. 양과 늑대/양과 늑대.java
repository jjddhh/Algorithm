import java.util.*;

class Solution {
    
    int[] l = new int[17];
    int[] r = new int[17];
    int[] visit = new int[1<<17];
    int ans = -1;
    int n;
    
    public int solution(int[] info, int[][] edges) {
        
        n = info.length;
        
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);
       
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            
            if(l[parent] == -1) l[parent] = child;
            else r[parent] = child;
        }
        
        solve(1, info);
        
        return ans;
    }
    
    public void solve(int state, int info[]) {
        if(visit[state] == 1) return;
        visit[state] = 1;
        
        int wolf = 0, total = 0;
        for(int i = 0; i < n; i++) {
            if((state & (1<<i)) != 0) {
                wolf += info[i];
                total++;
            }
        }
        
        if(wolf * 2 >= total) return;
        ans = Math.max(ans, total - wolf);
        
        for(int i = 0; i < n; i++){
            if((state & (1<<i)) == 0) continue;
            
            if(l[i] != -1) solve(state | (1<<l[i]), info);
            if(r[i] != -1) solve(state | (1<<r[i]), info);
        }
        
    }
}