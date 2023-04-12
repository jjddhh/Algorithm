import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int r, c, t;
    static int[][] arr = new int[51][51];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int top, bottom;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (top == 0 && arr[i][j] == -1) {
                    top = i;
                    bottom = i + 1;
                }
            }
        }

        for (int i = 1; i <= t; i++) {
            // 먼지 확산
            int[][] tmp = new int[51][51];
            for (int j = 1; j <= r; j++) {
                for (int k = 1; k <= c; k++) {
                    int cnt = 0;
                    for (int t = 0; t < 4; t++) {
                        int tx = dx[t] + k;
                        int ty = dy[t] + j;

                        if(tx < 1 || tx > c || ty < 1 || ty > r) continue;
                        if(arr[ty][tx] == -1) continue;
                        tmp[ty][tx] += (arr[j][k] / 5);
                        cnt++;
                    }
                    arr[j][k] -= (arr[j][k] / 5) * cnt;
                }
            }

            for (int j = 1; j <= r; j++) {
                for (int k = 1; k <= c; k++) {
                    if(arr[j][k] == -1) continue;
                    arr[j][k] += tmp[j][k];
                }
            }

            // 공기청정기 작동
            // 위쪽
            for (int j = top - 2; j >= 1; j--) {
                arr[j + 1][1] = arr[j][1];
            }

            for (int j = 2; j <= c; j++) {
                arr[1][j - 1] = arr[1][j];
            }

            for (int j = 2; j <= top; j++) {
                arr[j - 1][c] = arr[j][c];
            }

            for (int j = c - 1; j >= 2; j--) {
                arr[top][j + 1] = arr[top][j];
            }
            arr[top][2] = 0;

            // 아래쪽
            for (int j = bottom + 2; j <= r; j++) {
                arr[j - 1][1] = arr[j][1];
            }

            for (int j = 2; j <= c; j++) {
                arr[r][j - 1] = arr[r][j];
            }

            for (int j = r - 1; j >= bottom; j--) {
                arr[j + 1][c] = arr[j][c];
            }

            for (int j = c - 1; j >= 2; j--) {
                arr[bottom][j + 1] = arr[bottom][j];
            }
            arr[bottom][2] = 0;
        }

        int sum = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(arr[i][j] == -1) continue;
                sum += arr[i][j];
            }
        }

        System.out.println(sum);
    }
}