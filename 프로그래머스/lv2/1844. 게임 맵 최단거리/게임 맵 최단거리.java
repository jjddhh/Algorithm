import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        int[][] dp = new int[n + 1][m + 1];
        
        dp[0][0] = 1;
        queue.add(new Point(0, 0));
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int tx = dx[i] + cur.x;
                int ty = dy[i] + cur.y;
                
                if(tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                if(maps[ty][tx] == 0) continue;
                if(dp[ty][tx] == 0) {
                    dp[ty][tx] = dp[cur.y][cur.x] + 1;
                    queue.add(new Point(tx, ty));
                }
            }
        }
        
        int answer = dp[n - 1][m - 1] == 0 ? -1 : dp[n - 1][m - 1];
        
        return answer;
    }
    
    class Point {
        int x, y;
        
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}