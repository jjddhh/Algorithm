/*
 * 9465 - 스티커
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = parseInt(br.readLine());
        int n;

        for (int i = 1; i <= t; i++) {
            n = parseInt(br.readLine());
            int[][] arr = new int[3][n + 1];
            int[][] dp = new int[3][n + 1];

            for (int j = 1; j <= 2; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            for (int j = 2; j <= n; j++) {
                dp[1][j] = Math.max(dp[2][j - 1], dp[2][j - 2]) + arr[1][j];
                dp[2][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[2][j];
            }

            sb.append(Math.max(dp[1][n], dp[2][n])).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
