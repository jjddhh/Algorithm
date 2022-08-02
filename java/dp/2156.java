/*
 * 2156 - 포도주 시식
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = parseInt(br.readLine());
        int[] arr = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
             arr[i] = parseInt(br.readLine());
        }

        dp[1] = arr[1];
        dp[2] = dp[1] + arr[2];

        for (int i = 3; i <= n; i++) {
             dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[n]);

        br.close();
    }
}
