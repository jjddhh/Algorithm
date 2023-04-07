import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int h, w, n;
    private static int[] x = new int[101];
    private static int[] y = new int[101];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int ax = x[i], ay = y[i], bx = x[j], by = y[j];
                int width = ax * ay + bx * by;
                
                if(ax + bx <= w && Math.max(ay, by) <= h) {
                    max = Math.max(max, width);
                    continue;
                }
                if(Math.max(ax, bx) <= w && ay + by <= h) {
                    max = Math.max(max, width);
                    continue;
                }

                int tmp = bx;
                bx = by;
                by = tmp;

                if(ax + bx <= w && Math.max(ay, by) <= h) {
                    max = Math.max(max, width);
                    continue;
                }

                if(Math.max(ax, bx) <= w && ay + by <= h) {
                    max = Math.max(max, width);
                    continue;
                }

                tmp = ax;
                ax = ay;
                ay = tmp;

                if(ax + bx <= w && Math.max(ay, by) <= h) {
                    max = Math.max(max, width);
                    continue;
                }
                if(Math.max(ax, bx) <= w && ay + by <= h) {
                    max = Math.max(max, width);
                    continue;
                }

                tmp = bx;
                bx = by;
                by = tmp;

                if(ax + bx <= w && Math.max(ay, by) <= h) {
                    max = Math.max(max, width);
                    continue;
                }
                if(Math.max(ax, bx) <= w && ay + by <= h) {
                    max = Math.max(max, width);
                    continue;
                }
            }
        }


        System.out.println(max);
    }
}