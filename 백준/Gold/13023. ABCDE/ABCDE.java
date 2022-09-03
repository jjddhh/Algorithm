import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static boolean check = false;
    public static boolean visit[];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        Arrays.fill(visit, false);

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            if(check) break;
            visit[i] = true;
            dfs(0, i);
            visit[i] = false;
        }

        System.out.println(check ? 1 : 0);

        br.close();
    }

    public static void dfs(int depth, int index) {
        if (depth > 3) {
            check = true;
            return;
        }

        for (int num : graph.get(index)) {
            if (visit[num] == false) {
                visit[num] = true;
                dfs(depth + 1, num);
                visit[num] = false;
            }
        }
    }

}