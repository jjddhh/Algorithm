import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, min = Integer.MAX_VALUE;
    static int[] s = new int[11];
    static int[] b = new int[11];
    static boolean[] visit = new boolean[11];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(min);
    }

    static void dfs (int depth) {
        if(depth > 0) {
            int s_sum = 1;
            int b_sum = 0;
            for(int i = 0; i < n; i++) {
                if(visit[i]) {
                    s_sum *= s[i];
                    b_sum += b[i];
                }
            }

            min = Math.min(min, Math.abs(s_sum - b_sum));
        }

        if(depth == n) return;

        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            dfs(depth + 1);
            visit[i] = false;
        }
    }
}