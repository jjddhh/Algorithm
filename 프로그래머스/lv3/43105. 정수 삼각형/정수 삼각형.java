class Solution {
    int[][] dp = new int[501][501];
    
    public int solution(int[][] triangle) {
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) dp[i][j] = triangle[i][j] + dp[i - 1][j];
                else if (j == i) dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }
        
        return answer;
    }
}