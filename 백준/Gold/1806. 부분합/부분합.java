import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m, head, tail, total;
    private static int min = Integer.MAX_VALUE;
    private static int[] A;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n + 5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        total = A[0];
        while (head < n && tail < n) {
            if (total < m) {
                tail++;
                total += A[tail];
            } else {
                int tmp = tail - head + 1;
                if(tmp < min) min = tmp;
                total -= A[head];
                head++;
            }
        }

        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
