/*
 * 15649 - N과 M (1)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visit;
    public static int N;
    public static int M;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];
        visit = new boolean[N + 1];
        Arrays.fill(visit, false);

        dfs(1);

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int depth) {
        if (depth > M) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}