/*
 * 1935 - 후위 표기식2
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Double> stack = new Stack<>();
        Double[] array;

        int n = Integer.parseInt(br.readLine());
        array = new Double[n];
        String op = br.readLine();

        for (int i = 0; i < n; i++) {
            array[i] = Double.parseDouble(br.readLine());
        }
        char a = 'A';
        for (int i = 0; i < op.length(); i++) {
            char temp = op.charAt(i);
            Double front;
            Double back;

            switch (temp) {
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-':
                    back = stack.pop();
                    front = stack.pop();
                    stack.push(front - back);
                    break;
                case '*':
                    stack.push(stack.pop() * stack.pop());
                    break;
                case '/':
                    back = stack.pop();
                    front = stack.pop();
                    stack.push(front / back);
                    break;
                default:
                    stack.push(array[temp - 'A']);
            }
        }

        System.out.printf("%.2f", stack.pop());

        br.close();
    }
}
