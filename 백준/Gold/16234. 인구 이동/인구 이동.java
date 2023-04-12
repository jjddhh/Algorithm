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
    static int n, l, r;
    static int[][] arr = new int[51][51];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            boolean[][] visit = new boolean[51][51];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visit[i][j]) continue;
                    int sum = 0;
                    Queue<Point> queue = new LinkedList<>();
                    List<Point> list = new ArrayList<>();

                    queue.add(new Point(j, i));
                    list.add(new Point(j, i));
                    visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        Point poll = queue.poll();
                        sum += arr[poll.y][poll.x];

                        for (int k = 0; k < 4; k++) {
                            int tx = dx[k] + poll.x;
                            int ty = dy[k] + poll.y;

                            if(tx < 0 || tx >= n || ty < 0 || ty >= n || visit[ty][tx]) continue;
                            int gap = Math.abs(arr[poll.y][poll.x] - arr[ty][tx]);

                            if(l <= gap && gap <= r) {
                                queue.add(new Point(tx, ty));
                                list.add(new Point(tx, ty));
                                visit[ty][tx] = true;
                            }
                        }
                    }

                    if (list.size() > 1) {
                        int div = sum / list.size();
                        for (Point p : list) {
                            arr[p.y][p.x] = div;
                        }

                        flag = true;
                    }
                }
            }
            
            if(flag) day++;
        }

        System.out.println(day);
    }
}