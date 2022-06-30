/*
 * 10799 - 쇠막대기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        int count = 0;
        char temp = '(';
        
        String buffer = br.readLine();

        for (int i = 0; i < buffer.length(); i++) {
            if(buffer.charAt(i) == '(') stack.push('(');
            else {
                if(temp == '(') count += stack.size() - 1;
                else count += 1;
                stack.pop();
            }
            temp = buffer.charAt(i);
        }
        System.out.println(count);

        br.close();
    }
}
