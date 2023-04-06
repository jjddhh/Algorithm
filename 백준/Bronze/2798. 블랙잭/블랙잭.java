import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;
    private static List<Integer>[] list = new List[1001];
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= m) {
                        if(sum > max) max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}