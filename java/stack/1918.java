/*
 * 1918 - 후위 표기식
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> op = new Stack<>();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {

            switch (input.charAt(i)) {
                case '+':
                    while(op.isEmpty() == false && op.peek() != '(') sb.append(op.pop());
                    op.push('+');
                    break;
                case '-':
                    while(op.isEmpty() == false && op.peek() != '(') sb.append(op.pop());
                    op.push('-');
                    break;
                case '*':
                    if(op.isEmpty() == false && (op.peek() == '*' || op.peek() == '/')) sb.append(op.pop());
                    op.push('*');
                    break;
                case '/':
                    if(op.isEmpty() == false && (op.peek() == '*' || op.peek() == '/')) sb.append(op.pop());
                    op.push('/');
                    break;
                case '(':
                    op.push('(');
                    break;
                case ')':
                    while(op.isEmpty() == false && op.peek() != '(') sb.append(op.pop());
                    op.pop();
                    break;
                default:
                    sb.append(input.charAt(i));
            }
        }

        while (op.isEmpty() == false) {
            sb.append(op.pop());
        }

        System.out.println(sb);

        br.close();
    }
}
