import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[][] arr = new int[51][51];
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] cx = {1, 1, -1, -1};
    static int[] cy = {1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] cmd = new int[101];
        int[] dist = new int[101];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cmd[i] = Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 구름 세팅
        List<Point> list = new ArrayList<>();
        for (int i = 0; i <= 1; i++) {
            list.add(new Point(1, n - i));
            list.add(new Point(2, n - i));
        }

        for (int i = 0; i < m; i++) {
            boolean[][] visit = new boolean[51][51];

            // 구름 이동
            for (int j = 0; j < dist[i]; j++) {
                for (Point p : list) {
                    p.x += dx[cmd[i]];
                    p.y += dy[cmd[i]];

                    if(p.x > n) p.x = 1;
                    if(p.x < 1) p.x = n;
                    if(p.y > n) p.y = 1;
                    if(p.y < 1) p.y = n;
                }
            }

            for (Point p : list) {
                // 비 내림
                arr[p.y][p.x]++;
            }

            for (Point p : list) {
                // 물 복사
                for (int k = 0; k < 4; k++) {
                    int tx = cx[k] + p.x;
                    int ty = cy[k] + p.y;

                    if(tx < 1 || tx > n || ty < 1 || ty > n) continue;
                    if(arr[ty][tx] <= 0) continue;

                    arr[p.y][p.x]++;
                }

                visit[p.y][p.x] = true;
            }

            // 새 구름
            list = new ArrayList<>();

            for (int s = 1; s <= n; s++) {
                for (int t = 1; t <= n; t++) {
                    if(visit[s][t] || arr[s][t] < 2) continue;
                    arr[s][t] -= 2;
                    list.add(new Point(t, s));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += arr[i][j];

            }
        }

        System.out.println(sum);
    }
}