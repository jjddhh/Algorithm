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

        int cnt = 0;
        char prev_op = '(';
        for (int i = 0; i < word.length; i++) {
            if(word[i] == '(') stack.push(word[i]);
            else{
                if(prev_op == '(') {
                    stack.pop();
                    cnt += stack.size();
                } else{
                    stack.pop();
                    cnt += 1;
                }
            }

            prev_op = word[i];
        }

        System.out.println(cnt);
    }
}
