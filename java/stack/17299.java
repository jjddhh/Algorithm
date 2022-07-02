/*
 * 17299 - 오동큰수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 1000000; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            list[i] = temp;
            map.put(temp, map.get(temp) + 1);
        }


        for (int i = 0; i < list.length; i++) {
            int value = list[i];

            while (stack.isEmpty() == false && map.get(list[stack.peek()]) < map.get(value)) {
                   list[stack.pop()] = value;
            }
            stack.push(i);
        }

        while (stack.isEmpty() == false) {
            list[stack.pop()] = -1;
        }

        for (int m : list) {
            sb.append(m).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
