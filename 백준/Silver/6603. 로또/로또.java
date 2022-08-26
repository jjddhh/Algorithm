import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] S;
    public static boolean[] visit;
    public static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        do{
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0) break;

            arr = new int[k + 1];
            S = new int[k + 1];
            visit = new boolean[k + 1];
            Arrays.fill(visit, false);

            for (int i = 1; i <= k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, 1);

            sb.append('\n');
        }while(true);

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int depth, int start) {
        if (depth > 6) {
            for (int i = 1; i <= 6; i++) {
                sb.append(S[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= k; i++) {
            if(visit[i] == false){
                visit[i] = true;
                S[depth] = arr[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}