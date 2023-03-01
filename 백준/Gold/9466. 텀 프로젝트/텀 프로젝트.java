import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int t;

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int[] sector = new int[100001];
    private static int[] is_visit = new int[100001];

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            Arrays.fill(sector, 0);
            Arrays.fill(is_visit, 0);

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                sector[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if(is_visit[i] == 0) dfs(i);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if(is_visit[i] != -1) cnt++;
            }

            sb.append(cnt).append('\n');

            t--;
        }

        System.out.println(sb);
    }

    private static void dfs(int i) {
        int cur = i;
        while (true) {
            is_visit[cur] = i;
            cur = sector[cur];

            if (is_visit[cur] == i) {
                while (is_visit[cur] != -1) {
                    is_visit[cur] = -1;
                    cur = sector[cur];
                }
                return;
            } else if(is_visit[cur] != 0) return;
        }
    }
}
