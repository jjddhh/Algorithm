/*
 * 11057 - 오르막 수
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
        int mod = 10_007;

        int n = parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i - 1][k] % mod;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % mod);

        br.close();
    }
}
