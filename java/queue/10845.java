/*
 * 10845 - 큐
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        LinkedList<Integer> queue = new LinkedList<>();
        int back = -1;

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    back++;
                    break;
                case "pop":
                    if(queue.isEmpty()) sb.append("-1\n");
                    else {
                        sb.append(queue.pop() + "\n");
                        back--;
                    }
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.get(0) + "\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.get(back) + "\n");
                    break;
            }
        }
        System.out.println(sb);

        br.close();
    }
}
