import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m;

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int[][][] sector = new int[301][301][2];
    private static boolean[][] is_visit;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                sector[i][j][0] = Integer.parseInt(st.nextToken());

            }
        }
        
        int year = 0;
        while (true) {

            int check = isDivided();
            if (check == 2) {
                System.out.println(year);
                return;
            } else if (check == 1) {
                System.out.println(0);
                return;
            }

            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (queue.isEmpty() && sector[i][j][0] > 0) {
                        queue.add(new Point(j, i));
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }

            is_visit = new boolean[301][301];

            while (!queue.isEmpty()) {
                Point pt = queue.poll();
                if (sector[pt.y][pt.x][0] <= 0) continue;
                if (year <= sector[pt.y][pt.x][1]) year++;

                int sea = 0;
                for (int i = 0; i < 4; i++) {
                    int tx = pt.x + dx[i];
                    int ty = pt.y + dy[i];

                    if (tx < 1 || tx > m || ty < 1 || ty > n) continue;
                    if (sector[ty][tx][0] == 0) {
                        sea++;
                        continue;
                    }
                    if (sector[pt.y][pt.x][1] < sector[ty][tx][1]) continue;
                    if (is_visit[ty][tx]) continue;
                    is_visit[ty][tx] = true;
                    queue.add(new Point(tx, ty));
                }

                sector[pt.y][pt.x][0] -= sea;
                if (sector[pt.y][pt.x][0] <= 0) sector[pt.y][pt.x][0] = -1;
                sector[pt.y][pt.x][1]++;

//                for (int i = 1; i <= n; i++) {
//                    for (int j = 1; j <= m; j++) {
//                        System.out.printf("%d\t", sector[i][j][0]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if(sector[i][j][0] == -1) sector[i][j][0] = 0;
                }
            }

        }

    }

    private static int isDivided() {

        int seg[][] = new int[301][301];

        Stack<java.awt.Point> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                seg[i][j] = sector[i][j][0];
            }
        }

        int execute = 0;
        is_visit = new boolean[301][301];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (is_visit[i][j] || seg[i][j] <= 0) continue;

                stack.add(new java.awt.Point(j, i));
                while (!stack.isEmpty()) {
                    java.awt.Point pt = stack.pop();

                    for (int k = 0; k < 4; k++) {
                        int tx = pt.x + dx[k];
                        int ty = pt.y + dy[k];

                        if (tx < 1 || tx > m || ty < 1 || ty > n) continue;
                        if (is_visit[ty][tx]) continue;
                        if (seg[ty][tx] == 0) continue;
                        is_visit[ty][tx] = true;
                        seg[ty][tx] = seg[pt.y][pt.x];
                        stack.add(new java.awt.Point(tx, ty));
                    }
                }
                execute++;
            }
        }

        if (execute == 1) return 0;
        else if(execute == 0) return 1;
        else return 2;
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