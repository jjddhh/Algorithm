import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] input;
    public static boolean[] visit;
    public static int N;
    public static int M;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[M + 1];
        input = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(visit, false);

        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

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
            arr[depth] = input[i];
            dfs(depth + 1);
        }
    }
}