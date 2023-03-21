import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[91][2];
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int sub_i = 0; sub_i <= 1; sub_i++) {
                if(sub_i == 1) dp[i][1] = dp[i - 1][0];
                else if(sub_i == 0) dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            }
        }
        
        long sum = 0;
        for (int i = 0; i <= 1; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum);
        br.close();
    }
}
