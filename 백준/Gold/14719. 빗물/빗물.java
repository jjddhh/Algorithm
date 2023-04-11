import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int h, w;
    static int[] arr = new int[501];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < w; i++) {
            int left = 0, right = 0;
            for(int j = 0; j <= i - 1; j++) {
                left = Math.max(left, arr[j]);
            }

            for(int j = i + 1; j < w; j++) {
                right = Math.max(right, arr[j]);
            }

            int min = Math.min(left, right);

            sum += min - arr[i] > 0 ? min - arr[i] : 0;
        }

        System.out.println(sum);
    }
}