import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<Integer>[] set = new Set[n + 1];
        for(int i = 1; i <= n; i++) {
            set[i] = new HashSet<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set[a].add(b);
            set[b].add(a);
        }

        int cnt = 0;
        for(int i = 1; i <= n - 2; i++) {
            for(int j = i + 1; j <= n - 1; j++) {
                for(int k = j + 1; k <= n; k++) {
                    if(set[i].contains(j) || set[i].contains(k) || set[j].contains(k)) continue;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}