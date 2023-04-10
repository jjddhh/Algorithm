import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, len, max = 1;
    static int[] arr;
    static boolean[] seq = new boolean[51];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < n - 1; i++) {
            for(int j = n - 1; j >= i + 1; j--) {
                if(arr[i] + arr[i + 1] > arr[j]) {
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        System.out.println(max);
    }
}