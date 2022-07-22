/*
 * 10844 - 쉬운 계단 수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int mod = 1_000_000_000;

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int sub_i = 0; sub_i <= 9; sub_i++) {
                if(sub_i == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }
                else if (sub_i == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                } else {
                    dp[i][sub_i] = (dp[i - 1][sub_i - 1] + dp[i - 1][sub_i + 1]) % mod;
                }
            }
        }
        
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % mod);
        br.close();
    }
}
