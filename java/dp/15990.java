/*
 * 15990 - 1, 2, 3 더하기 5
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int mod = 1_000_000_009;

        int count = Integer.parseInt(br.readLine());
        long[][] dp = new long[100000 + 1][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
        }

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append((dp[num][1] + dp[num][2] + dp[num][3]) % mod).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
