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

    private static int[][] sector = new int[1001][1001];
    private static boolean[][][] is_visit = new boolean[1001][1001][2];

    public static void main(String[] args) throws IOException {

        Queue<Coordinate> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                sector[i][j] = Integer.parseInt(String.valueOf(str[j - 1]));
            }
        }

        queue.add(new Coordinate(1, 1, 1));

        while (!queue.isEmpty()) {
            Coordinate cd = queue.poll();

            if(cd.x == m && cd.y == n){
                System.out.println(cd.dist);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int tx, ty;
                tx = cd.x + dx[d];
                ty = cd.y + dy[d];

                if(tx > m || tx < 1 || ty > n || ty < 1) continue;

                if (sector[ty][tx] == 0) {
                    if (cd.already_break && !is_visit[ty][tx][1]) {
                        queue.add(new Coordinate(tx, ty, cd.dist + 1, true));
                        is_visit[ty][tx][1] = true;
                    } else if (!cd.already_break && !is_visit[ty][tx][0]){
                        queue.add(new Coordinate(tx, ty, cd.dist + 1, false));
                        is_visit[ty][tx][0] = true;
                    }
                } else {
                    if(cd.already_break) continue;
                    queue.add(new Coordinate(tx, ty, cd.dist + 1, true));
                    is_visit[ty][tx][1] = true;
                }
            }
        }

        System.out.println(-1);
    }
    
    static class Coordinate{
        public int x;
        public int y;
        public int dist;
        public boolean already_break;

        public Coordinate(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.already_break = false;
        }

        public Coordinate(int x, int y, int dist, boolean already_break) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.already_break = already_break;
        }
    }
}