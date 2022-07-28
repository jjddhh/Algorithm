/*
 * 15988 - 1, 2, 3 더하기 3
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int mod = 1_000_000_009;

        int t = Integer.parseInt(br.readLine());
        int n;
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 1; i <= t; i++){
            n = Integer.parseInt(br.readLine());

            for (int j = 4; j <= n; j++) {
                if(dp[j] == 0) dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % mod;
            }

            sb.append(dp[n] % mod).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
