// dfs 풀이하면 4^2500 ... 잘못된 접근

// 먼저 최단거리 찾고, 그 안에서 symbol 추가하는 방식으로 접근

import java.util.*;

class Solution {
    char[][] maze = new char[51][51];
    boolean[][][] visit = new boolean[51][51][2501];
    int[] dx = {0, -1, 1, 0};
    int[] dy = {1, 0, 0, -1};
    char[] symbol = {'d', 'l', 'r', 'u'};
    boolean escape = false;
    String answer = "";
    int min;
    int dist;
    int width;
    int height;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dist = k;
        height = n;
        width = m;
        
        for(int i = 1; i <= n; i++) {
            Arrays.fill(maze[i], '.');
        }
        maze[x][y] = 'S';
        maze[r][c] = 'E';
        
        dfs(0, x, y, "");
        if(answer.length() == 0) answer = "impossible";

        return answer;
    }
    
    void dfs(int mov, int curY, int curX, String route) {
        if(escape) return;
        
        if(mov == dist) {
            if(maze[curY][curX] == 'E') {
                answer = route;
                min = mov;
                escape = true;
            }
            
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int tx = dx[i] + curX;
            int ty = dy[i] + curY;
            
            if(tx < 1 || tx > width || ty < 1 || ty > height) continue;
            if(visit[ty][tx][mov]) continue;
            visit[ty][tx][mov] = true;
            dfs(mov + 1, ty, tx, route + symbol[i]);            
        }
    }
}