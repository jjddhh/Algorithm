import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        StringTokenizer st;
        
        int input = Integer.parseInt(br.readLine());

        for(int i = 0; i < input; i++){
             st = new StringTokenizer(br.readLine(), " ");

             while(st.hasMoreTokens()){
                 String token = st.nextToken();

                 for (int sub_i = 0; sub_i < token.length(); sub_i++) {
                     stack.add(token.charAt(sub_i));
                 }
                 while(stack.isEmpty() == false){
                     sb.append(stack.pop());
                 }

                 sb.append(" ");
             }

             sb.append("\n");
        }

        System.out.println(sb);
    }
}
