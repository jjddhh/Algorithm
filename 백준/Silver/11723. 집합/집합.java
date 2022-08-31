import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static int M;
    public static boolean bit[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        bit = new boolean[21];
        Arrays.fill(bit, false);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = 0;

            switch (op) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    bit[num] = true;
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bit[num] = false;
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if(bit[num] == true) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if(bit[num] == true) bit[num] = false;
                    else bit[num] = true;
                    break;
                case "all":
                    Arrays.fill(bit, true);
                    break;
                case "empty":
                    Arrays.fill(bit, false);
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}