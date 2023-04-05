import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;
    private static int min = Integer.MAX_VALUE;
    private static List<CCTV> cctvs = new ArrayList<>();
    private static int[][] arr = new int[10][10];
    private static int[][] map = new int[10][10];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(1 <= arr[i][j] && arr[i][j] <= 5) cctvs.add(new CCTV(j, i, arr[i][j]));

                if(arr[i][j] != 0) {
                    if(arr[i][j] == 6) map[i][j] = -1;
                    else map[i][j] = 1;
                }
            }
        }


        dfs(0);

        System.out.println(min);
    }

    static void dfs(int depth) {
        if(depth == cctvs.size()) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 0) cnt++;
                }
            }
            min = Math.min(min, cnt);
            return;
        }

        CCTV cctv = cctvs.get(depth);

        switch (cctv.type) {
            case 1:
                // 위
                up(cctv);
                dfs(depth + 1);
                upUndo(cctv);

                // 아래
                down(cctv);
                dfs(depth + 1);
                downUndo(cctv);

                // 왼쪽
                left(cctv);
                dfs(depth + 1);
                leftUndo(cctv);

                // 오른쪽
                right(cctv);
                dfs(depth + 1);
                rightUndo(cctv);
                break;
            case 2:
                // 위 아래
                up(cctv);
                down(cctv);
                dfs(depth + 1);
                upUndo(cctv);
                downUndo(cctv);

                // 왼쪽 오른쪽
                left(cctv);
                right(cctv);
                dfs(depth + 1);
                leftUndo(cctv);
                rightUndo(cctv);
                break;
            case 3:
                // 위 오른쪽
                up(cctv);
                right(cctv);
                dfs(depth + 1);
                upUndo(cctv);
                rightUndo(cctv);

                // 오른쪽 아래
                right(cctv);
                down(cctv);
                dfs(depth + 1);
                rightUndo(cctv);
                downUndo(cctv);

                // 아래 왼쪽
                down(cctv);
                left(cctv);
                dfs(depth + 1);
                downUndo(cctv);
                leftUndo(cctv);

                // 왼쪽 위
                left(cctv);
                up(cctv);
                dfs(depth + 1);
                leftUndo(cctv);
                upUndo(cctv);
                break;
            case 4:
                // 왼쪽 위 오른쪽
                left(cctv);
                up(cctv);
                right(cctv);
                dfs(depth + 1);
                leftUndo(cctv);
                upUndo(cctv);
                rightUndo(cctv);

                // 위 오른쪽 아래
                up(cctv);
                right(cctv);
                down(cctv);
                dfs(depth + 1);
                upUndo(cctv);
                rightUndo(cctv);
                downUndo(cctv);

                // 오른쪽 아래 왼쪽
                right(cctv);
                down(cctv);
                left(cctv);
                dfs(depth + 1);
                rightUndo(cctv);
                downUndo(cctv);
                leftUndo(cctv);

                //아래 왼쪽 위
                down(cctv);
                left(cctv);
                up(cctv);
                dfs(depth + 1);
                downUndo(cctv);
                leftUndo(cctv);
                upUndo(cctv);
                break;
            case 5:
                // 왼쪽 위 오른쪽 아래
                left(cctv);
                up(cctv);
                right(cctv);
                down(cctv);
                dfs(depth + 1);
                leftUndo(cctv);
                upUndo(cctv);
                rightUndo(cctv);
                downUndo(cctv);
                break;
        }
    }

    private static void rightUndo(CCTV cctv) {
        for(int i = cctv.x + 1; i < m; i++) {
            if(map[cctv.y][i] == -1) break;
            map[cctv.y][i]--;
        }
    }

    private static void leftUndo(CCTV cctv) {
        for(int i = cctv.x - 1; i >= 0; i--) {
            if(map[cctv.y][i] == -1) break;
            map[cctv.y][i]--;
        }
    }

    private static void right(CCTV cctv) {
        for(int i = cctv.x + 1; i < m; i++) {
            if(map[cctv.y][i] == -1) break;
            map[cctv.y][i]++;
        }
    }

    private static void left(CCTV cctv) {
        for(int i = cctv.x - 1; i >= 0; i--) {
            if(map[cctv.y][i] == -1) break;
            map[cctv.y][i]++;
        }
    }

    private static void downUndo(CCTV cctv) {
        for(int i = cctv.y + 1; i < n; i++) {
            if(map[i][cctv.x] == -1) break;
            map[i][cctv.x]--;
        }
    }

    private static void down(CCTV cctv) {
        for(int i = cctv.y + 1; i < n; i++) {
            if(map[i][cctv.x] == -1) break;
            map[i][cctv.x]++;
        }
    }

    private static void upUndo(CCTV cctv) {
        for(int i = cctv.y - 1; i >= 0; i--) {
            if(map[i][cctv.x] == -1) break;
            map[i][cctv.x]--;
        }
    }

    private static void up(CCTV cctv) {
        for(int i = cctv.y - 1; i >= 0; i--) {
            if(map[i][cctv.x] == -1) break;
            map[i][cctv.x]++;
        }
    }

    static class CCTV {
        int x, y;
        int type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}