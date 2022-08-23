import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] input;
    public static boolean[] visit;
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        input = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(visit, false);

        seq(1);

        System.out.println(sb);

        br.close();
    }

    private static void seq(int depth) {
        if (depth > N) {
            for (int i = 1; i <= N; i++) {
                sb.append(input[i]).append(" ");
            }
            sb.append('\n');
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