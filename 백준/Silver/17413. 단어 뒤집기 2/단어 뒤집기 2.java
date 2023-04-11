import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<String> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), "<> ", true);

        while (st.hasMoreTokens()) {
            queue.add(st.nextToken());
        }

        String pop = " ";
        String reverse = " ";
        String temp;

        while(!queue.isEmpty()){
            pop = queue.poll();

            if(pop.equals("<")){
                sb.append(pop);

                while(!((pop = queue.poll()).equals(">"))) sb.append(pop);
                sb.append(pop);
            }else{
                StringBuffer stringBuffer = new StringBuffer(pop);

                sb.append(stringBuffer.reverse());
            }
        }

        System.out.println(sb);

        br.close();
    }
}
