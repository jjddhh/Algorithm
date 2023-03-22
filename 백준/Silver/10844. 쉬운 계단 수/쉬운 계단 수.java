import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n;

    private static long[][] dp = new long[101][10];

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] % 1_000_000_000;
            dp[i][9] = dp[i - 1][8] % 1_000_000_000;

            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) sum += dp[n][i];

        System.out.println(sum % 1_000_000_000);
    }
}