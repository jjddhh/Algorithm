import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int t;
    private static int[][] arr = new int[501][501];

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= t; i++) {
            for (int j = 1; j <= i; j++) {
                if(j == 1) arr[i][j] += arr[i - 1][1];
                else if(j == i) arr[i][j] += arr[i - 1][i - 1];
                else {
                    arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= t; i++) {
            if(arr[t][i] > max) max = arr[t][i];
        }

        System.out.println(max);
    }
}