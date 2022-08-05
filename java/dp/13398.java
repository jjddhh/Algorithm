/*
 * 13398 - 연속합 2
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
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = dp[1][0] = dp[1][1] = arr[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

            if(sum < Math.max(dp[i][0], dp[i][1])) sum = Math.max(dp[i][0], dp[i][1]);
        }

        System.out.println(sum);

        br.close();
    }
}
