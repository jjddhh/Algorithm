/*
 * 1309 - 동물원
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int mod = 9901;

        int n = parseInt(br.readLine());
        long[][] dp = new long[n + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % mod);

        br.close();
    }
}
