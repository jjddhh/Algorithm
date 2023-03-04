import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n;

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int[][] sector = new int[101][101];
    private static boolean[][] is_visit;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                sector[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        is_visit = new boolean[101][101];

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(sector[i][j] == 0 || is_visit[i][j]) continue;
                cnt++;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(j, i));
                sector[i][j] = cnt;
                is_visit[i][j] = true;

                while (!queue.isEmpty()) {
                    Point pt = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int tx = pt.x + dx[k];
                        int ty = pt.y + dy[k];
                        if(tx < 1 || tx > n || ty < 1 || ty > n) continue;
                        if(sector[ty][tx] == 0 || is_visit[ty][tx]) continue;
                        queue.add(new Point(tx, ty));
                        is_visit[ty][tx] = true;
                        sector[ty][tx] = cnt;
                    }
                }
            }
        }

        int short_cut = Integer.MAX_VALUE;
        int dist[][] = new int[101][101];
        for(int k = 1; k <= n; k++)
            Arrays.fill(dist[k], -1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(sector[i][j] == 0) continue;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(j, i));
                dist[i][j] = 0;

                boolean flag = false;
                while(!queue.isEmpty() && !flag){
                    Point pt = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int tx = pt.x + dx[k];
                        int ty = pt.y + dy[k];
                        if(tx < 1 || tx > n || ty < 1 || ty > n) continue;
                        if(dist[ty][tx] >= 0 || sector[i][j] == sector[ty][tx]) continue;
                        if(sector[ty][tx] != 0 && sector[i][j] != sector[ty][tx]){
                            short_cut = Math.min(dist[pt.y][pt.x], short_cut);
                            flag = true;
                            break;
                        }
                        queue.add(new Point(tx, ty));
                        dist[ty][tx] = dist[pt.y][pt.x] + 1;
                    }
                }

                for(int k = 1; k <= n; k++)
                    Arrays.fill(dist[k], -1);
            }
        }

        System.out.println(short_cut);
    }


    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}