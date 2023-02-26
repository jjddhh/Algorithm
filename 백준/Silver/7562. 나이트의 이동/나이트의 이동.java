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
    private static int[] dx = {2, 1, 2, 1, -2, -1, -2, -1};
    private static int[] dy = {1, 2, -1, -2, 1, 2, -1, -2};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while (t > 0) {
            int[][] sector = new int[301][301];
            boolean[][] is_visit = new boolean[301][301];
            Queue<Point> queue = new LinkedList<>();

            int l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Point cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            queue.add(cur);

            st = new StringTokenizer(br.readLine());
            Point goal = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            while (!queue.isEmpty()) {
                Point pt = queue.poll();
                if(pt.equals(goal)) {
                    sb.append(sector[pt.y][pt.x]).append('\n');
                    break;
                }

                for (int d = 0; d < 8; d++) {
                    int tx, ty;
                    tx = pt.x + dx[d];
                    ty = pt.y + dy[d];
                    if(tx >= l || tx < 0 || ty >= l || ty < 0) continue;
                    if(is_visit[ty][tx]) continue;
                    queue.add(new Point(tx, ty));
                    sector[ty][tx] = sector[pt.y][pt.x] + 1;
                    is_visit[ty][tx] = true;
                }
            }

            t--;
        }

        System.out.println(sb);
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
