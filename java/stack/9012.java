import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack;

        int input = Integer.parseInt(br.readLine());

        for(int i = 0; i < input; i++) {
            stack = new Stack<>();
            String str = br.readLine();

            try {
                for (int sub_i = 0; sub_i < str.length(); sub_i++) {
                    if (str.charAt(sub_i) == '(') stack.add(str.charAt(sub_i));
                    else stack.pop();
                }

                if(stack.isEmpty()) sb.append("YES\n");
                else sb.append("NO\n");

            }catch (EmptyStackException e){
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}
