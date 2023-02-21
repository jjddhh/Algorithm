import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int t, m, n, k;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        while (t > 0) {
            boolean[][] farm = new boolean[51][51];
            boolean[][] is_visit = new boolean[51][51];

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int x, y;
            while (k > 0) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                farm[y][x] = true;
                k--;
            }

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!farm[i][j] || is_visit[i][j]) continue;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(j, i));
                    is_visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        Point pt = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int tx, ty;
                            tx = pt.x + dx[d];
                            ty = pt.y + dy[d];
                            if(tx >= m || tx < 0 || ty >= n || ty < 0) continue;
                            if(!farm[ty][tx] || is_visit[ty][tx]) continue;
                            queue.add(new Point(tx, ty));
                            is_visit[ty][tx] = true;
                        }
                    }

                    cnt++;
                }
            }


            sb.append(cnt).append('\n');
            t--;
        }

        System.out.println(sb);
    }
}
