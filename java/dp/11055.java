/*
 * 11055 - 가장 큰 증가 부분 수열
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
        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        int sum = arr[1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }

            if(sum < dp[i]) sum = dp[i];
        }

        System.out.println(sum);

        br.close();
    }
}
