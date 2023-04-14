class Solution {
    int[] arr = new int[21];
    boolean[] visit = new boolean[21];
    int mov = Integer.MAX_VALUE;
    int cnt, len;
    
    public int solution(String name) {
        len = name.length();
        int trans = 0;
        for(int i = 0; i < len; i++) {
            char alpha = name.charAt(i);
            if(alpha != 'A') {
                trans += Math.min(alpha - 'A', 26 - (alpha - 'A'));
            }
        }
        
        for(int i = 0; i < len; i++) {
            if(name.charAt(i) != 'A' && i != 0) {
                arr[cnt] = i;
                cnt++;
            }
        }
        
        dfs(0, 0, 0);
        
        return mov + trans;
    }
    
    void dfs(int depth, int cur, int dist) {     
        if(depth == cnt) {
            mov = Math.min(mov, dist);
            return;
        }
        
        for(int i = 0; i < cnt; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            int tmp = Math.min(Math.abs(arr[i] - cur), len - Math.abs(arr[i] - cur));
            dfs(depth + 1, arr[i], tmp + dist);
            visit[i] = false;
        }
    }
}