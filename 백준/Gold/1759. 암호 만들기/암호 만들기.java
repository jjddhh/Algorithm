import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static char[] arr;
    public static char[] pw;
    public static boolean[] visit;
    public static int L, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C + 1];
        pw = new char[L + 1];
        visit = new boolean[C + 1];
        Arrays.fill(visit, false);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(1, 1);

        sb.append('\n');


        System.out.println(sb);

        br.close();
    }

    private static void dfs(int depth, int start) {
        if (depth > L) {
            int vo = 0;
            int co = 0;

            for (int i = 1; i <= L; i++) {
                switch (pw[i]) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vo++;
                        break;
                    default:
                        co++;
                }
            }

            if(vo < 1 || co < 2) return;

            for (int i = 1; i <= L; i++) {
                sb.append(pw[i]);
            }

            sb.append('\n');
            return;
        }

        for (int i = start; i <= C; i++) {
            if(visit[i] == false){
                visit[i] = true;
                pw[depth] = arr[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}
