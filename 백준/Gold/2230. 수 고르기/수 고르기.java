import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m, head, tail;
    private static int min = Integer.MAX_VALUE;
    private static int[] A;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        while (head < n && tail < n) {
            int tmp = A[tail] - A[head];
            if (tmp < m) {
                tail++;
            } else {
                if(tmp < min) min = tmp;
                head++;
            }
        }


        System.out.println(min);
    }
}
