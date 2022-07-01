/*
 * 17298 - 오큰수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < list.length; i++) {
            int value = list[i];

            while (stack.isEmpty() == false && list[stack.peek()] < value) {
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
