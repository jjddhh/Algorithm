import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, a, b;
    static int[][] graph = new int[1001][1001];


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph[n/2][n/2] = 1;
        if(m == 1) {
            a = n / 2;
            b = n / 2;
        }

        dfs(n/2 - 1, n/2 - 1, 2);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(graph[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append(b + 1).append(' ').append(a + 1);

        System.out.println(sb);
    }

    static void dfs(int x, int y, int start) {
        if(x < 0) return;

        for(int i = x + 1; i <= n - 1 - x; i++) {
            if(start == m) {
                a = i;
                b = y;
            }
            graph[y][i] = start++;
        }

        for(int i = y + 1; i <= n - 1 - y; i++) {
            if(start == m) {
                a = n - x - 1;
                b = i;
            }
            graph[i][n - x - 1] = start++;
        }

        for(int i = n - 2 - x; i >= x; i--) {
            if(start == m) {
                a = i;
                b = n - 1 - y;
            }
            graph[n - 1 - y][i] = start++;
        }

        for(int i = n - 2 - y; i >= y; i--) {
            if(start == m) {
                a = x;
                b = i;
            }
            graph[i][x] = start++;
        }

        dfs(x - 1, y - 1, start);
    }
}