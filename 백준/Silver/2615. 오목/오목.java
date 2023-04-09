import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[19][19];
    static boolean[][] visit = new boolean[19][19];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(arr[i][j] == 0) continue;
                visit[i][j] = true;

                n = 0;
                n++;
                col_dfs(i, j);
                if(n == 5) {
                    System.out.println(arr[i][j]);
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }

                n = 0;
                n++;
                row_dfs(i, j);
                if(n == 5) {
                    System.out.println(arr[i][j]);
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }

                n = 0;
                n++;
                left_cross_dfs(i, j);
                if (n == 5) {
                    System.out.println(arr[i][j]);
                    System.out.println((i + 4 + 1) + " " + (j - 4 + 1));
                    return;
                }

                n = 0;
                n++;
                right_cross_dfs(i, j);
                if (n == 5) {
                    System.out.println(arr[i][j]);
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }

                visit[i][j] = false;
            }
        }

        System.out.println(0);
    }

    private static void col_dfs(int i, int j) {
        if (j + 1 < 19 && arr[i][j + 1] == arr[i][j] && !visit[i][j + 1]) {
            visit[i][j + 1] = true;
            n++;
            col_dfs(i, j + 1);
            visit[i][j + 1] = false;
        }

        if (j - 1 >= 0 && arr[i][j - 1] == arr[i][j] && !visit[i][j - 1]) {
            visit[i][j - 1] = true;
            n++;
            col_dfs(i, j - 1);
            visit[i][j - 1] = false;
        }
    }

    private static void row_dfs(int i, int j) {
        if (i + 1 < 19 && arr[i + 1][j] == arr[i][j] && !visit[i + 1][j]) {
            visit[i + 1][j] = true;
            n++;
            row_dfs(i + 1, j);
            visit[i + 1][j] = false;
        }

        if (i - 1 >= 0 && arr[i - 1][j] == arr[i][j] && !visit[i - 1][j]) {
            visit[i - 1][j] = true;
            n++;
            row_dfs(i - 1, j);
            visit[i - 1][j] = false;
        }
    }

    private static void left_cross_dfs(int i, int j) {
        if (i + 1 < 19 && j - 1 >= 0 && arr[i + 1][j - 1] == arr[i][j] && !visit[i + 1][j - 1]) {
            visit[i + 1][j - 1] = true;
            n++;
            left_cross_dfs(i + 1, j - 1);
            visit[i + 1][j - 1] = false;
        }

        if (i - 1 >= 0 && j + 1 < 19 && arr[i - 1][j + 1] == arr[i][j] && !visit[i - 1][j + 1]) {
            visit[i - 1][j + 1] = true;
            n++;
            left_cross_dfs(i - 1, j + 1);
            visit[i - 1][j + 1] = false;
        }
    }

    private static void right_cross_dfs(int i, int j) {
        if (i + 1 < 19 && j + 1 < 19 && arr[i + 1][j + 1] == arr[i][j] && !visit[i + 1][j + 1]) {
            visit[i + 1][j + 1] = true;
            n++;
            right_cross_dfs(i + 1, j + 1);
            visit[i + 1][j + 1] = false;
        }

        if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] == arr[i][j] && !visit[i - 1][j - 1]) {
            visit[i - 1][j - 1] = true;
            n++;
            right_cross_dfs(i - 1, j - 1);
            visit[i - 1][j - 1] = false;
        }
    }
}