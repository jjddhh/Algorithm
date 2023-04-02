import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Queue<Point> que = new LinkedList<>();
        boolean[][] map = new boolean[105][105];
        boolean[][] visit = new boolean[105][105];
        int[][] dp = new int[105][105];
        
        for(int i = 0; i < rectangle.length; i++) {
            for(int j = rectangle[i][1] * 2; j <= rectangle[i][3] * 2; j++) {
                for(int k = rectangle[i][0] * 2; k <= rectangle[i][2] * 2; k++) {
                    map[j][k] = true;
                }   
            }
        }
        
        for(int i = 0; i < rectangle.length; i++) {
            for(int j = rectangle[i][1] * 2 + 1; j <= rectangle[i][3] * 2 - 1; j++) {
                for(int k = rectangle[i][0] * 2 + 1; k <= rectangle[i][2] * 2 - 1; k++) {
                    map[j][k] = false;
                }   
            }
        }
        
        que.add(new Point(characterX * 2, characterY * 2));
        map[characterY * 2][characterX * 2] = false;
        
        while (!que.isEmpty()) {
            Point cur = que.poll();
            if(cur.x == itemX * 2 && cur.y == itemY * 2) break;
            
            for(int i = 0; i < 4; i++) {
                int tx = dx[i] + cur.x;
                int ty = dy[i] + cur.y;
                
                if(!map[ty][tx]) continue;
                if(tx < 2 || tx > 100 || ty < 2 || ty > 100) continue;
                
                map[ty][tx] = false;
                dp[ty][tx] = dp[cur.y][cur.x] + 1;
                que.add(new Point(tx, ty));
            }
        }
        
        int answer = dp[itemY * 2][itemX * 2] / 2;
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