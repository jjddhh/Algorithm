/*
 * 11052 - 카드 구매하기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int count = st.countTokens();
        for (int i = 1; i <= count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int sub_i = 1; sub_i <= i; sub_i++) {
                dp[i] = Math.max(dp[i], dp[i - sub_i] + arr[sub_i]);
            }
        }

        System.out.println(dp[n]);
        br.close();
    }
}
