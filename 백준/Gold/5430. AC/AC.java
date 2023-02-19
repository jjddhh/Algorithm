import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int t, m;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while (t > 0) {
            char[] op = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> list = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean error = false;
            for (int i = 0; i < op.length; i++) {
                if (op[i] == 'D') {
                    if(list.isEmpty()){
                        error = true;
                        break;
                    } else {
                        if(reverse) list.pollLast();
                        else list.pollFirst();
                    }
                }else {
                    reverse = reverse ? false : true;
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if(reverse) {
                    while (!list.isEmpty()) {
                        if(list.size() == 1) sb.append(list.pollLast());
                        else sb.append(list.pollLast()).append(',');
                    }
                } else{
                    while (!list.isEmpty()) {
                        if(list.size() == 1) sb.append(list.pollFirst());
                        else sb.append(list.pollFirst()).append(',');
                    }
                }
                sb.append("]\n");
            }

            t--;
        }

        System.out.println(sb);
    }
}
