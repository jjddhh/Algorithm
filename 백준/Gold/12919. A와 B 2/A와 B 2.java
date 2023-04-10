import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String s, b;
    static int result;
    static int[][] arr = new int[21][21];

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        b = br.readLine();

        dfs(b);

        System.out.println(result);
    }

    static void dfs(String str) {
        if(result == 1) return;

        if(str.equals(s)) {
            result = 1;
            return;
        }

        if(str.length() == s.length()) return;

        int len = str.length();
        if(str.charAt(len - 1) == 'A') {
            dfs(str.substring(0, len - 1));
        }

        if(str.charAt(0) == 'B') {
            sb = new StringBuilder(str);
            dfs(sb.reverse().substring(0, len - 1));
        }
    }
}