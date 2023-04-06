import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;
    private static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[40][40];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < m - 2; i++) {
            for(int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    int sum = 0;
                    for(int t = 0; t < n; t++) {
                        sum += Math.max(arr[t][i], Math.max(arr[t][j], arr[t][k]));
                    }
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}