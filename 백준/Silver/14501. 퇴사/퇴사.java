import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[] day;
    public static int[] pay;
    public static int[] pay_sum;
    public static boolean[] visit;
    public static int N;
    public static int MAX;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        day = new int[N + 1];
        pay = new int[N + 1];
        pay_sum = new int[N + 2];
        visit = new boolean[N + 1];
        Arrays.fill(visit, false);

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 1);

        System.out.println(MAX);

        br.close();
    }

    private static void dfs(int depth, int start) {
        if (start == N + 1) {
            int sum = 0;
            for (int i = 1; i <= depth - 1; i++) {
                sum += pay_sum[i];
            }

            if(MAX < sum) MAX = sum;

            return;
        }else if(start > N + 1){
            int sum = 0;
            for (int i = 1; i <= depth - 2; i++) {
                sum += pay_sum[i];
            }

            if(MAX < sum) MAX = sum;

            return;
        }

        for (int i = start; i <= N; i++) {
            if(visit[i] == false){
                visit[i] = true;
                pay_sum[depth] = pay[i];
                dfs(depth + 1, day[i] + i);
                visit[i] = false;
            }
        }
    }
}