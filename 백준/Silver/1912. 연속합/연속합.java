import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[1];
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            int sum = arr[i] + dp[i - 1];

            if (dp[i - 1] > 0) {
                dp[i] = sum;
            } else {
                dp[i] = arr[i];
            }

            if(max < dp[i]) max = dp[i];
        }

        System.out.println(max);

        br.close();
    }
}
