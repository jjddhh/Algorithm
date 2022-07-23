/*
 * 11053 - 가장 긴 증가하는 부분 수열
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int sub_i = 1; sub_i < i; sub_i++) {
                if (arr[sub_i] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[sub_i] + 1);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[n]);
        br.close();
    }
}
