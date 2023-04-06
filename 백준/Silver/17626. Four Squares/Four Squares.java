import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dfs(0, n);

        System.out.println(min);
    }

    static void dfs(int depth, int num) {
        if(num == 0) {
            min = Math.min(min, depth);
            return;
        }

        if(depth >= min) return;

        int sqrt = (int)Math.sqrt(num);
        int bt = (int)Math.sqrt(num / 2);
        for(int i = sqrt; i >= bt; i--) {
            dfs(depth + 1, num - (i * i));
        }
    }
}