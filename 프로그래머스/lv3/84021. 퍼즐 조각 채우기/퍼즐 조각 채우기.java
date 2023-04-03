import java.util.*;

class Solution {
    List<Segment> empty_seg = new ArrayList<>();
    List<Segment> seg = new ArrayList<>();
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        int height = game_board.length;
        int width = game_board[0].length;
        
        // game_board 빈 칸
        boolean[][] visit = new boolean[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(game_board[i][j] == 1 || visit[i][j]) continue;
                List<Point> list = new ArrayList<>();
                Queue<Point> queue = new LinkedList<>();
                boolean[][] puzzle = new boolean[51][51];
                int sx = j, sy = i;
                int ex = j, ey = i;
                queue.add(new Point(j, i));
                list.add(new Point(j, i));
                visit[i][j] = true;
                
                while(!queue.isEmpty()) {
                    Point cur = queue.poll();

                    for(int k = 0; k < 4; k++) {
                        int tx = dx[k] + cur.x;
                        int ty = dy[k] + cur.y;
                        
                        if(tx < 0 || tx >= width || ty < 0 || ty >= height) continue;
                        if(game_board[ty][tx] == 1 || visit[ty][tx]) continue;

                        visit[ty][tx] = true;
                        if(tx < sx) sx = tx;
                        if(ty < sy) sy = ty;
                        if(tx > ex) ex = tx;
                        if(ty > ey) ey = ty;
                        queue.add(new Point(tx, ty));
                        list.add(new Point(tx, ty));
                    }
                }
                
                int cnt = 0;
                for(Point p : list) {
                    puzzle[p.y - sy][p.x- sx] = true;
                    cnt++;
                }
                
                empty_seg.add(new Segment(ex - sx + 1, ey - sy + 1, cnt, puzzle));
            }
        }
        
        // table 조각
        visit = new boolean[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(table[i][j] == 0 || visit[i][j]) continue;
                List<Point> list = new ArrayList<>();
                Queue<Point> queue = new LinkedList<>();
                int sx = j, sy = i;
                int ex = j, ey = i;
                
                queue.add(new Point(j, i));
                list.add(new Point(j, i));
                visit[i][j] = true;
                
                while(!queue.isEmpty()) {
                    Point cur = queue.poll();

                    for(int k = 0; k < 4; k++) {
                        int tx = dx[k] + cur.x;
                        int ty = dy[k] + cur.y;
                        
                        if(tx < 0 || tx >= width || ty < 0 || ty >= height) continue;
                        if(table[ty][tx] == 0 || visit[ty][tx]) continue;

                        visit[ty][tx] = true;
                        if(tx < sx) sx = tx;
                        if(ty < sy) sy = ty;
                        if(tx > ex) ex = tx;
                        if(ty > ey) ey = ty;
                        queue.add(new Point(tx, ty));
                        list.add(new Point(tx, ty));
                    }
                }
                
                int cnt = 0;
                boolean[][] puzzle = new boolean[51][51];
                for(Point p : list) {
                    puzzle[p.y - sy][p.x - sx] = true;
                    cnt++;
                }
                
                seg.add(new Segment(ex - sx + 1, ey - sy + 1, cnt, puzzle));
            }
        }
        

        
        // for(int k = 0; k < seg.size(); k++){
        //     Segment te = seg.get(k);
        //     boolean[][] test = te.arr;
        //     for(int i = 0; i < te.h; i++) {
        //         for(int j = 0; j < te.w; j++) {
        //             System.out.print(test[i][j] ? 1 : 0);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }   
        
        
        int answer = 0;
        int len = seg.size();
        boolean[] used = new boolean[len];
        for(Segment emt : empty_seg) {
            
            for(int z = 0; z < 3; z++) {
                for(int x = 0; x < 3; x++) {
                    System.out.print(emt.arr[z][x] ? 1 : 0);
                }
                System.out.println();
            }
            System.out.println("현재 빈칸");
            
            // boolean[][] tes = emt.arr;
            // for(int r = 0; r < emt.h; r++) {
            //     for(int q = 0; q < emt.w; q++) {
            //         System.out.print(tes[r][q] ? 1 : 0);
            //     }
            //     System.out.println();
            // }
            // System.out.println("현재");
            boolean flag = false;
            for(int i = 0; i < len; i++) {
                if(used[i]) continue;
                Segment smt = seg.get(i);
                // System.out.println("w : " + smt.w + " h : " + smt.h);
                
                for(int j = 0; j < 4; j++) {
                    rotate(smt);
        
                    // if(emt.w != smt.w || emt.h != smt.h) continue;
                    if(check(emt, smt)) {
                        answer += smt.count;
                        used[i] = true;
                        flag = true;
                        // for(int z = 0; z < 3; z++) {
                        //     for(int x = 0; x < 3; x++) {
                        //         System.out.print(emt.arr[z][x] ? 1 : 0);
                        //     }
                        //     System.out.println();
                        // }
                        // System.out.println("위는 빈칸 아래는 퍼즐");
                        // for(int z = 0; z < 3; z++) {
                        //     for(int x = 0; x < 3; x++) {
                        //         System.out.print(smt.arr[z][x] ? 1 : 0);
                        //     }
                        //     System.out.println();
                        // }
                        // System.out.println(" 발견 !");
                        break;
                    }
                    // System.out.println(answer + ": @@@ ");
                }
                if(flag) break;
            }
        }
        
        return answer;
    }
    
    void swap (Segment smt) {
        int tmp = smt.w;
        smt.w = smt.h;
        smt.h = tmp;
    }
    
    void rotate (Segment smt) {
        boolean[][] a = smt.arr;
        boolean[][] b = new boolean[51][51];
        // for(int i = 0; i < smt.h; i++) {
        //     for(int j = 0; j < smt.w; j++) {
        //         // if(a[i][j]) b[smt.h - 1 - j][i] = true;
        //         b[i][j] = a[i][j];
        //         System.out.print(b[i][j] ? 'O' : 'X');
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        for(int i = 0; i < smt.w; i++) {
            for(int j = 0; j < smt.h; j++) {
                // if(a[i][j]) b[smt.h - 1 - j][i] = true;
                b[i][j] = a[smt.h - 1 - j][i];
            }
        }
        
        smt.arr = b;
        swap(smt);
        
        // for(int i = 0; i < 3; i++) {
        //     for(int j = 0; j < 3; j++) {
        //         System.out.print(a[i][j] ? 1 : 0);
        //     }
        //     System.out.println();
        // }
        // System.out.println(" 함수 끝 ");
        
        
    }
    
    boolean check(Segment emt, Segment smt) {
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                if(emt.arr[i][j] != smt.arr[i][j]) return false;
            }
        }
        return true;
    }
    
    class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    class Segment {
        int w, h;
        int count;
        boolean[][] arr;
        
        Segment(int w, int h, int count, boolean[][] arr) {
            this.w = w;
            this.h = h;
            this.count = count;
            this.arr = arr;
        }
    }
}