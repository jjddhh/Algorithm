import java.util.*;

class Solution {
    
    int[][] dp = new int[201][201];
    
    public int solution(int alp, int cop, int[][] problems) {
        int len = problems.length;
        int alp_goal = -1, cop_goal = -1;
        
        for(int i = 0; i < len; i++){
            if(alp_goal < problems[i][0]) alp_goal = problems[i][0];
            if(cop_goal < problems[i][1]) cop_goal = problems[i][1];
        }
        
        alp = Math.min(alp, alp_goal);
        cop = Math.min(cop, cop_goal);
        
        for(int i = 0; i < 201; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= alp_goal; i++) {
            for(int j = cop; j <= cop_goal; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                for(int k = 0; k < len; k++) {
                    int alp_req, cop_req, alp_rwd, cop_rwd, cost;
                    alp_req = problems[k][0];
                    cop_req = problems[k][1];
                    alp_rwd = problems[k][2];
                    cop_rwd = problems[k][3];
                    cost = problems[k][4];
                    if(i < alp_req || j < cop_req) continue;
                    int alp_nxt = Math.min(alp_goal, i + alp_rwd);
                    int cop_nxt = Math.min(cop_goal, j + cop_rwd);
                    dp[alp_nxt][cop_nxt] = Math.min(dp[alp_nxt][cop_nxt], cost + dp[i][j]);
                }
            }
        }
        
        return dp[alp_goal][cop_goal];
    }
}