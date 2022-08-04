/*
 * 11054 - 가장 긴 바이토닉 부분 수열
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
            dp[i][0] = dp[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if(arr[i] > arr[j]) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                }
            }
        }

        int sum = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if(arr[i] < arr[j]) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                }
            }

            if(sum < dp[i][0]) sum = dp[i][0];
        }

        System.out.println(sum);

        br.close();
    }
}
