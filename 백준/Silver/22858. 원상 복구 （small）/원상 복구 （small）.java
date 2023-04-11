import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, k;
    static int[] arr = new int[10001];
    static int[] cur = new int[10001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cur[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < k; j++) {
            int[] tmp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                tmp[arr[i]] = cur[i];
            }
            cur = tmp;
        }

        for (int i = 1; i <= n; i++) {
            sb.append(cur[i]).append(' ');
        }
        System.out.println(sb);
    }
}