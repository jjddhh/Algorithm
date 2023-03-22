import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n;

    private static Consult[] consults = new Consult[1_500_100];
    private static long[] dp = new long[1_500_100];

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            consults[i] = new Consult(t, p);
        }

        long max = 0;
        for (int i = n; i >= 1; i--) {

            if(consults[i].t + i <= n + 1){
                dp[i] = Math.max(consults[i].p + dp[consults[i].t + i], dp[i + 1]);

                if(max < dp[i]) max = dp[i];
            }else{
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(max);
    }

    static class Consult{
        public int t;
        public int p;

        public Consult(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
}