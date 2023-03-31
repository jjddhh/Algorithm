class Solution {
    
    int answer = 0;
    boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        
        visit = new boolean[dungeons.length];
        bt(0, k, dungeons);
        
        return answer;
    }
    
    void bt(int depth, int k, int[][] dungeons) {
        boolean flag = true;
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && k >= dungeons[i][0]) flag = false;
        }
        
        if(flag) {
            answer = Math.max(answer, depth);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visit[i] || k < dungeons[i][0]) continue;
            visit[i] = true;
            bt(depth + 1, k - dungeons[i][1], dungeons);
            visit[i] = false;
        }
    }
}