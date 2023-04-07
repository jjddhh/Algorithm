import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, min = Integer.MAX_VALUE;
    static String t;
    static int[] fee = new int[20];
    static String[] title = new String[20];

    public static void main(String[] args) throws IOException {
        t = br.readLine();
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            fee[i] = Integer.parseInt(st.nextToken());
            title[i] = st.nextToken();
        }

        dfs(t, 0, 0);

        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    static void dfs (String remain, int charge, int depth) {
        if(remain.equals("")) {
            min = Math.min(min, charge);
            return;
        }

        if(depth == n) return;

        // 책 구매 x
        dfs(remain, charge, depth + 1);

        // 책 구매 o
        int len = title[depth].length();
        for(int i = 0; i < len; i++) {
            String reg = title[depth].substring(i, i + 1);
            remain = remain.replaceFirst(reg, "");
        }
        dfs(remain, charge + fee[depth], depth + 1);
    }
}