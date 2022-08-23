import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] input;
    public static boolean[] visit;
    public static int N;
    public static int MAX;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N + 1];
        input = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(visit, false);

        seq(1);

        System.out.println(MAX);

        br.close();
    }

    private static void seq(int depth) {
        if (depth > N) {
            int sum = 0;

            for (int i = 1; i <= N - 1; i++) {
                sum += Math.abs(input[i] - input[i + 1]);
            }

            if(MAX < sum) MAX = sum;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                input[depth] = arr[i];
                seq(depth + 1);
                visit[i] = false;
            }
        }
    }
}