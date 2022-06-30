/*
 * 1158 - 요세푸스 문제
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

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k;
        int sub = k = Integer.parseInt(st.nextToken());

        // 현재 위치에서 sub - 1개 뒤에 있는 index 가리켜야 하므로 -1
        sub--;
        // index 0 부터 시작하므로 -1
        k--;
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            k %= n;
            int pop = queue.get(k);
            queue.remove(k);
            k += sub;
            n--;

            if(n != 0) sb.append(pop + ", ");
            else sb.append(pop + ">");
        }

        System.out.println(sb);

        br.close();
    }
}
