class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                boolean flag = false;
                for(int k = 0; k < puddles.length; k++) {
                    if(puddles[k][0] == j + 1 && puddles[k][1] == i + 1) flag = true;
                }
                if(flag) continue;
                
                if(i - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i - 1][j]);
                if(j - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i][j - 1]);
                
                dp[i][j] %= 1_000_000_007;
            }
        }
        
        
        int answer = dp[n - 1][m - 1];
        return answer % 1_000_000_007;
    }
}