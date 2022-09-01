import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static int N;
    public static int S;
    public static int cnt;
    public static int seq[];
    public static int input[];
    public static int bit[];
    public static boolean visit[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        seq = new int[N + 1];
        input = new int[N + 1];
        bit = new int[100_001];
        visit = new boolean[N + 1];
        Arrays.fill(visit, false);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dfs(i, 1, 1);
        }

        System.out.println(cnt);

        br.close();
    }

    public static void dfs(int std, int depth, int start) {
        if (depth > std) {
            int sum = 0;
            for (int i = 1; i <= std; i++) {
                sum += input[i];
            }

            if(sum == S) cnt++;

            return;
        }

        for (int i = start; i <= N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                input[depth] = seq[i];
                dfs(std, depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}