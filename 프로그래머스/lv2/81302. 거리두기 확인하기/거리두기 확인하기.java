import java.util.*;

class Solution {
    int[] answer = new int[5];
    char[][][] seat = new char[6][6][6];
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    seat[i][j][k] = places[i][j].charAt(k);
                }
            }
        }
        
        for(int i = 0; i < 5; i++) {
            Queue<Point> queue = new LinkedList<>();
            boolean flag = false;
            boolean[][] visit = new boolean[5][5];
            
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(seat[i][j][k] == 'P') {
                        queue.add(new Point(k, j));
                        visit[j][k] = true;
                        
                        while(!queue.isEmpty()) {
                            Point cur = queue.poll();
                            
                            for(int r = 0; r < 4; r++) {
                                int tx = cur.x + dx[r];
                                int ty = cur.y + dy[r];
                                int manhatan = Math.abs(tx - k) + Math.abs(ty - j);
                                
                                if(tx < 0 || tx >= 5 || ty < 0 || ty >= 5 || visit[ty][tx]) continue;
                                if(manhatan > 2) continue;
                                if(seat[i][ty][tx] == 'X') continue;
                                if(seat[i][ty][tx] == 'P') {
                                    flag = true;
                                    break;
                                }
                                
                                queue.add(new Point(tx, ty));
                                visit[ty][tx] = true;
                            }
                            if(flag) break;
                        }
                        if(flag) break;
                    }
                    if(flag) break;
                }
                if(flag) break;
            }
            if(flag) answer[i] = 0;
            else answer[i] = 1;
        }
        
        
        return answer;
    }
    
    static class Point {
        public int x, y;
        
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}