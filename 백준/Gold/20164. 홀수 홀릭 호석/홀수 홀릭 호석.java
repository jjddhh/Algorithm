import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        n = br.readLine();

        dfs(n, odd_cnt(n));

        System.out.println(min + " " + max);
    }

    private static void dfs(String str, int odd_cnt) {
        int len = str.length();
        if(len == 1) {
            min = Math.min(odd_cnt, min);
            max = Math.max(odd_cnt, max);
            return;
        }

        if(len == 2) {
            int num = (str.charAt(0) - '0') + (str.charAt(1) - '0');
            String tmp = String.valueOf(num);
            dfs(tmp, odd_cnt + odd_cnt(tmp));
        } else {
            for (int i = 0; i < len - 2; i++) {
                for (int j = i + 1; j < len - 1; j++) {
                    for (int k = j + 1; k < len; k++) {
                        int a = Integer.parseInt(str.substring(0, i + 1));
                        int b = Integer.parseInt(str.substring(i + 1, j + 1));
                        int c = Integer.parseInt(str.substring(j + 1, len));
                        int num = a + b + c;

                        String tmp = String.valueOf(num);
                        dfs(tmp, odd_cnt + odd_cnt(tmp));
                    }
                }
            }
        }
    }

    private static int odd_cnt(String str) {
        int cnt = 0;

        int len = str.length();
        for (int i = 0; i < len; i++) {
            if((str.charAt(i) - '0') % 2 == 1) cnt++;
        }

        return cnt;
    }
}