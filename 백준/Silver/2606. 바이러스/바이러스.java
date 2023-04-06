import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;
    private static List<Integer>[] list = new List[101];
    private static boolean[] visit = new boolean[101];

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            List<Integer> vert = list[cur];
            Iterator<Integer> iterator = vert.iterator();
            while(iterator.hasNext()) {
                int next = iterator.next();
                if(visit[next]) continue;
                visit[next] = true;
                queue.add(next);
            }
        }

        int cnt = -1;
        for(int i = 1; i <= n; i++) {
            if(visit[i]) cnt++;

        }

        System.out.println(cnt);
    }
}