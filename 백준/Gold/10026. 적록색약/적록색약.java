import java.awt.*;
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

    public static void main(String[] args) throws IOException {

        char[][] sector = new char[101][101];

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] color = br.readLine().toCharArray();
            for (int j = 0; j < color.length; j++) {
                sector[i][j] = color[j];
            }
        }

        int cnt_nor = 0;
        int cnt_ill = 0;

        boolean[][] is_visit = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(is_visit[i][j]) continue;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(j, i));
                is_visit[i][j] = true;
                char color = sector[i][j];

                while (!queue.isEmpty()) {
                    Point pt = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int tx, ty;
                        tx = pt.x + dx[d];
                        ty = pt.y + dy[d];
                        if(tx >= n || tx < 0 || ty >= n || ty < 0) continue;
                        if(sector[ty][tx] != color || is_visit[ty][tx]) continue;
                        queue.add(new Point(tx, ty));
                        is_visit[ty][tx] = true;
                    }
                }

                cnt_nor++;
            }
        }

        sb.append(cnt_nor).append(" ");

        is_visit = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(is_visit[i][j]) continue;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(j, i));
                is_visit[i][j] = true;
                char color = sector[i][j];

                while (!queue.isEmpty()) {
                    Point pt = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int tx, ty;
                        tx = pt.x + dx[d];
                        ty = pt.y + dy[d];
                        if (tx >= n || tx < 0 || ty >= n || ty < 0) continue;
                        if (is_visit[ty][tx]) continue;
                        if (color == 'B' && sector[ty][tx] != 'B') continue;
                        else if(color != 'B' && sector[ty][tx] == 'B') continue;

                        queue.add(new Point(tx, ty));
                        is_visit[ty][tx] = true;
                    }
                }

                cnt_ill++;
            }
        }

        sb.append(cnt_ill);

        System.out.println(sb);
    }
}
