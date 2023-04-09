import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, num, min = Integer.MAX_VALUE;
    static int[][] arr = new int[21][21];
    static boolean[] link = new boolean[21];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(num = 1; num < n; num++) {
            dfs(0, 1);
        }

        System.out.println(min);
    }

    static void dfs(int depth, int start) {
        if(depth == num) {
            int t_link = 0;
            int t_start = 0;
            for(int i = 1; i <= n - 1; i++) {
                for(int j = i + 1; j <= n; j++) {
                    if(link[i] && link[j]) t_link += arr[i][j] + arr[j][i];
                    else if(!link[i] && !link[j]) t_start += arr[i][j] + arr[j][i];
                }
            }

            min = Math.min(min, Math.abs(t_link - t_start));

            return;
        }

        for(int i = start; i <= 20; i++) {
            link[i] = true;
            dfs(depth + 1, i + 1);
            link[i] = false;
        }
    }
}