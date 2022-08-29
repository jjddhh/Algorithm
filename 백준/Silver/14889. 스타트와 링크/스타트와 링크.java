import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[][] player;
    public static boolean[] visit;
    public static int N;
    public static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        player = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(visit, false);

        for(int i = 1; i <= N; i++){

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 1);

        System.out.println(MIN);

        br.close();
    }

    private static void dfs(int depth, int index) {
        if (depth == N / 2 + 1) {

            int start = 0;
            int link = 0;

            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (visit[i] == true && visit[j] == true) {
                        start = start + player[i][j] + player[j][i];
                    }
                    else if (visit[i] == false && visit[j] == false) {
                        link = link + player[i][j] + player[j][i];

                    }
                }
            }

            int gap = Math.abs(start - link);

            if(MIN > gap) MIN = gap;

            if(MIN == 0){
                System.out.println(MIN);
                System.exit(0);
            }

            return;
        }

        for (int i = index; i <= N; i++) {
            if(visit[i] == false){
                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}