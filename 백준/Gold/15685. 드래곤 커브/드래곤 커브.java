import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static boolean[][] visit = new boolean[101][101];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] rx = {1, 0, 1};
    static int[] ry = {0, 1, 1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int x, y, d, g;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            list.add(d);
            while (g > 0) {
                for (int k = list.size() - 1; k >= 0; k--) {
                    list.add((list.get(k) + 1) % 4);
                }
                g--;
            }

            visit[y][x] = true;
            for (Integer t : list) {
                x = dx[t] + x;
                y = dy[t] + y;
                visit[y][x] = true;
            }
        }

        int rect = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if(!visit[i][j]) continue;

                int cnt = 0;
                for (int k = 0; k < 3; k++) {
                    int tx = rx[k] + j;
                    int ty = ry[k] + i;

                    if(tx > 100 || ty > 100 || !visit[ty][tx]) continue;
                    cnt++;
                }

                if(cnt == 3) rect++;
            }
        }

        System.out.println(rect);
    }
}