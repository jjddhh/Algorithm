/*
 * 1932 - 정수 삼각형
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; st.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = dp[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(j == 1) dp[i][j] = dp[i - 1][1] + arr[i][j];
                else if(j == i) dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];

                if(sum < dp[i][j]) sum = dp[i][j];
            }
        }

        System.out.println(sum);

        br.close();
    }
}
