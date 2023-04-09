import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, min = Integer.MAX_VALUE;
    static int[][] arr = new int[11][11];
    static boolean[][] flower = new boolean[11][11];
    static boolean[][] visit = new boolean[11][11];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs (int cnt, int cost) {
        if(cnt == 3) {
            min = Math.min(min, cost);
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(flower[i][j] || visit[i][j]) continue;
                visit[i][j] = true;

                boolean flag = false;
                for(int k = 0; k < 4; k++) {
                    int tx = dx[k] + j;
                    int ty = dy[k] + i;

                    if(tx < 0 || tx >= n || ty < 0 || ty >= n || flower[ty][tx]) {
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    int sum = 0;
                    flower[i][j] = true;
                    sum += arr[i][j];
                    for(int k = 0; k < 4; k++) {
                        int tx = dx[k] + j;
                        int ty = dy[k] + i;
                        flower[ty][tx] = true;
                        sum += arr[ty][tx];
                    }

                    dfs(cnt + 1, cost + sum);

                    flower[i][j] = false;
                    for(int k = 0; k < 4; k++) {
                        int tx = dx[k] + j;
                        int ty = dy[k] + i;
                        flower[ty][tx] = false;
                    }
                }

                visit[i][j] = false;
            }
        }

    }
}