import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, mov = 0;
    static boolean flag;
    static int[][] arr = new int[100001][2];
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            arr[idx][0] = Integer.parseInt(st.nextToken());
            arr[idx][1] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        System.out.println(mov);
    }

    private static void dfs(int vert) {
        if(arr[vert][0] != -1) {
            mov++;
            dfs(arr[vert][0]);
        }

        visit[vert] = true;

        if(arr[vert][1] != -1) {
            mov++;
            dfs(arr[vert][1]);
        }

        if(flag) return;

        for (int i = 1; i <= n; i++) {
            if(!visit[i]) {
                mov++;
                return;
            }
        }

        flag = true;
    }
}