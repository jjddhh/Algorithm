import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n;

    public static void main(String[] args) throws IOException {

        Deque<Integer> queue = new ArrayDeque<>();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            switch (op) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.getFirst()).append('\n');
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.getLast()).append('\n');
                    break;
                case "pop":
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.pop()).append('\n');
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
            }
        }

        System.out.println(sb);
    }
}
