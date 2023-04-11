import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] visit = new boolean[101];
    static int len;
    static String input;

    public static void main(String[] args) throws IOException {
        input = br.readLine();
        len = input.length();

        dfs(0, len);

        System.out.println(sb);
    }

    private static void dfs(int start, int end) {
        if(start == end) return;

        String str = input.substring(start, end);
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        int idx = start + str.indexOf(String.valueOf(arr[0]));
        visit[idx] = true;
        for (int i = 0; i < len; i++) {
            if(visit[i]) sb.append(input.charAt(i));
        }
        sb.append('\n');

        dfs(idx + 1, end);

        dfs(start, idx);
    }
}