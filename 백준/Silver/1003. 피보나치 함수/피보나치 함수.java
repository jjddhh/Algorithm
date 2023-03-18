import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int t;

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            int one = 0, zero = 0;
            int val[][] = new int[41][2];
            val[0][0] = 1; val[0][1] = 0;
            val[1][0] = 0; val[1][1] = 1;

            for (int i = 2; i <= n; i++) {
                val[i][0] = val[i - 1][0] + val[i - 2][0];
                val[i][1] = val[i - 1][1] + val[i - 2][1];
            }

            sb.append(val[n][0] + " " + val[n][1]).append('\n');

            t--;
        }

        System.out.println(sb);
    }
}