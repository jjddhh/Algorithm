import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;
    private static HashSet<Integer> set = new HashSet<>();
    private static String[] arr;
    private static boolean[] visit = new boolean[100];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        dfs(0, "");

        System.out.println(set.size());
    }

    static void dfs(int depth, String num) {
        if(depth == m) {
            set.add(Integer.parseInt(num));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            dfs(depth + 1, num + arr[i]);
            visit[i] = false;
        }
    }
}