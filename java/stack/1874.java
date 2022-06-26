import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;


public class Main {

    public static int[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        int current = 1;

        int input = Integer.parseInt(br.readLine());
        list = new int[input];

        for (int i = 0; i < input; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        try {
            for (int i = 0; i < input; i++) {
                if (list[i] > temp) {
                    while (list[i] >= current) {
                        stack.add(current++);
                        sb.append("+\n");
                    }
                    stack.pop();
                    sb.append("-\n");
                } else {
                    while (stack.pop() != list[i]) {}
                    sb.append("-\n");
                }
                temp = list[i];
            }
        } catch (EmptyStackException e) {
            sb = new StringBuilder("NO");
        }

        System.out.println(sb);
    }
}
