import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int N, M, V;
    public static boolean visit[];
    public static int[][] graph;
    public static Queue<Integer> queue;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        Arrays.fill(visit, false);

        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(V);
        sb.append('\n');

        Arrays.fill(visit, false);
        bfs(V);

        System.out.println(sb);

        br.close();
    }

    public static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i <= N; i++) {
            if (visit[i] == false && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue = new LinkedList<>();
        sb.append(start).append(" ");
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (visit[i] == false && graph[temp][i] == 1) {
                    sb.append(i).append(" ");
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}