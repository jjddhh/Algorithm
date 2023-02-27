import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int t;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while (t > 0) {
            char[][] sector = new char[1001][1001];
            boolean[][] is_visit = new boolean[1001][1001];
            Queue<Coordinate> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            Coordinate cur = null;
            for (int i = 0; i < h; i++) {
                char[] str = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    sector[i][j] = str[j];
                    if(str[j] == '*') queue.add(new Coordinate(j, i, '*'));
                    else if(str[j] == '@') cur = new Coordinate(j, i, 1, '@');
                }
            }
            queue.add(cur);

            boolean flag = false;
            while (!queue.isEmpty()) {
                if(flag) break;
                Coordinate cd = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int tx, ty;
                    tx = cd.x + dx[d];
                    ty = cd.y + dy[d];

                    if(cd.type == '@'){
                        if(tx >= w || tx < 0 || ty >= h || ty < 0) {
                            sb.append(cd.time).append('\n');
                            flag = true;
                            break;
                        }
                        if(sector[ty][tx] != '.' || is_visit[ty][tx]) continue;

                        queue.add(new Coordinate(tx, ty, cd.time + 1,'@'));
                        sector[ty][tx] = cd.type;
                        is_visit[ty][tx] = true;
                    } else{
                        if(tx >= w || tx < 0 || ty >= h || ty < 0) continue;
                        if(sector[ty][tx] == '#' || (is_visit[ty][tx] && sector[ty][tx] == '*')) continue;

                        queue.add(new Coordinate(tx, ty, '*'));
                        sector[ty][tx] = cd.type;
                        is_visit[ty][tx] = true;
                    }
                }
            }

            if(!flag) sb.append("IMPOSSIBLE").append('\n');

            t--;
        }

        System.out.println(sb);
    }
    
    static class Coordinate{
        public int x;
        public int y;
        public int time;
        public char type;

        public Coordinate(int x, int y, int time, char type) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }
        public Coordinate(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
