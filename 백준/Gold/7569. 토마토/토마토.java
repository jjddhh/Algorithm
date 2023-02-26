import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m, h;
    private static int[] dx = {1, 0, 0, -1, 0, 0};
    private static int[] dy = {0, 1, 0, 0, -1, 0};
    private static int[] dz = {0, 0, 1, 0, 0, -1};

    public static void main(String[] args) throws IOException {

        int[][][] sector = new int[101][101][101];

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());


        boolean[][][] is_visit = new boolean[101][101][101];
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    sector[i][j][k] = Integer.parseInt(st.nextToken());
                    if(sector[i][j][k] == 1) {
                        queue.add(new Coordinate(k, j, i));
                        is_visit[i][j][k] = true;
                    }
                }
            }
        }

        int days = 0;
        while (!queue.isEmpty()) {
            Coordinate cd = queue.poll();

            for (int d = 0; d < 6; d++) {
                int tx, ty, tz;
                tx = cd.x + dx[d];
                ty = cd.y + dy[d];
                tz = cd.z + dz[d];
                if(tx >= m || tx < 0 || ty >= n || ty < 0 || tz >= h || tz < 0) continue;
                if(sector[tz][ty][tx] != 0 || is_visit[tz][ty][tx]) continue;
                queue.add(new Coordinate(tx, ty, tz));
                sector[tz][ty][tx] = sector[cd.z][cd.y][cd.x] + 1;
                if(sector[tz][ty][tx] > days) days = sector[tz][ty][tx];
                is_visit[tz][ty][tx] = true;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(sector[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(days == 0 ? 0 : days - 1);
    }

    static class Coordinate{
        public int x;
        public int y;
        public int z;

        public Coordinate(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
