import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n;

    private static int[] arr = new int[100001];
    private static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[1];
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = i - 1; j >= 1; j--) {
                if(arr[j] < arr[i]){
                    if(temp < dp[j]) temp = dp[j];
                }
            }
            dp[i] = temp + arr[i];

            if(max < dp[i]) max = dp[i];
        }

        System.out.println(max);
    }
}