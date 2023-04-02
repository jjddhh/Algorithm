import java.util.*;

class Solution {
    int parent[];
        
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || computers[i][j] == 0) continue;
                
                union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(find(i));
        }
        
        int answer = set.size();
        return answer;
    }
    
    public boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		if(x <= y) parent[y] = x;
		else parent[x] = y;
		return true;
	}
	
	public int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
}