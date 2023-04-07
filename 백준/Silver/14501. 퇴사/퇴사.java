import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n;
    private static int[][] arr = new int[20][2];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[20];

        for(int i = 1; i <= n + 1; i++) {
            for(int j = 1; j < i; j++) {
                if(j + arr[j][0] <= i) dp[i] = Math.max(dp[i], dp[j] + arr[j][1]);
            }
        }

        System.out.println(dp[n + 1]);
    }
}