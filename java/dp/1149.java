/*
 * 1149 - RGB거리
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
        StringTokenizer st;

        int n = parseInt(br.readLine());
        int[][] house = new int[n + 1][4];
        int[][] dp = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];
        dp[1][3] = house[1][3];

        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + house[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + house[i][2];
            dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][3];
        }

        System.out.println(Math.min(Math.min(dp[n][1], dp[n][2]), dp[n][3]));

        br.close();
    }
}
