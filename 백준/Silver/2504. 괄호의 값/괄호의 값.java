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

        char[] word = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int sum = 0;
        int num = 1;
        for (int i = 0; i < word.length; i++) {
            if(word[i] == '(') {
                num *= 2;
                stack.push(word[i]);
            } else if (word[i] == '[') {
                num *= 3;
                stack.push(word[i]);
            } else if (word[i] == ')') {
                if(stack.isEmpty() || stack.peek() != '('){
                    System.out.println(0);
                    return;
                }
                if(word[i - 1] == '(') sum += num;
                stack.pop();
                num /= 2;
            } else{
                if(stack.isEmpty() || stack.peek() != '['){
                    System.out.println(0);
                    return;
                }
                if(word[i - 1] == '[') sum += num;
                stack.pop();
                num /= 3;
            }
        }

        if(stack.isEmpty()) System.out.println(sum);
        else System.out.println(0);
    }
}
