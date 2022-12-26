import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, max;
    private static int[] gd;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        gd = new int[n];

        for (int i = 0; i < n; i++) {
            gd[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(gd);

        for (int i = 0; i < n; i++) {
            max = Math.max(max, gd[i] * (n - i));
        }

        System.out.println(max);
    }
}
