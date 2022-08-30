import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static char[] symbol;
    public static int[] input;
    public static boolean[] visit;
    public static int k;
    public static long MIN = Long.MAX_VALUE;
    public static long MAX = Long.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        symbol = new char[k + 1];
        input = new int[k + 2];
        visit = new boolean[10];
        Arrays.fill(visit, false);

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= k; i++){
            symbol[i] = st.nextToken().charAt(0);
        }

        for(int i = 0; i <= 9; i++){
            visit[i] = true;
            input[0] = i;
            dfs(1, i);
            visit[i] = false;
        }

        System.out.println(MAX);

        String temp = String.valueOf(MIN);
        if(temp.length() < k + 1) System.out.printf("0%d",MIN);
        else System.out.printf("%d",MIN);

        br.close();
    }

    private static void dfs(int depth, int index) {
        if (depth > k) {

            long sum = 0;
            for (int i = 0; i <= k; i++) {
                sum = sum * 10 + input[i];
            }

            if(sum > MAX) MAX = sum;
            if(sum < MIN) MIN = sum;

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if(visit[i] == false){
                if((symbol[depth] == '>' && index > i) || (symbol[depth] == '<' && index < i)){
                    visit[i] = true;
                    input[depth] = i;
                    dfs(depth + 1, i);
                    visit[i] = false;
                }
            }
        }
    }
}