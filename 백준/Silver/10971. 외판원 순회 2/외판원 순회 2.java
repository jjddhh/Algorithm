import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[][] W;
    public static int[] input;
    public static boolean[] visit;
    public static int N;
    public static int MIN = 4_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N + 1][N + 1];
        input = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            tsp(1, i, i);
            visit[i] = false;
        }

        System.out.println(MIN);

        br.close();
    }

    private static void tsp(int depth, int start, int cur) {
        if (depth > N - 1) {
            int sum = 0;

            for (int i = 1; i <= N - 1; i++) {
                sum += input[i];
            }
            sum += W[cur][start];

            if(MIN > sum && W[cur][start] != 0) MIN = sum;

            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visit[i] == false && W[cur][i] != 0){
                visit[i] = true;
                input[depth] = W[cur][i];
                tsp(depth + 1, start, i);
                visit[i] = false;
            }
        }
    }
}