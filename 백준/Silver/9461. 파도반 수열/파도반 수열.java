import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int t;

    private static long[] dp = new long[100001];

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        dp[1] = 1; dp[2] = 1; dp[3] = 1;
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 4; i <= n; i++) {
                if(dp[i] == 0) dp[i] = dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[n]).append('\n');
            t--;
        }

        System.out.println(sb);
    }
}