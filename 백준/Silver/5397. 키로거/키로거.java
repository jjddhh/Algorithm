import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, x, c;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<String> front = new Stack<>();
            Stack<String> back = new Stack<>();

            String str = br.readLine();
            int length = str.length();
            for(int j = 0; j < length; j++){
                String input = String.valueOf(str.charAt(j));

                if(input.equals("<")){
                    if(front.isEmpty()) continue;
                    back.push(front.pop());
                }
                else if(input.equals(">")) {
                    if(back.isEmpty()) continue;
                    front.push(back.pop());
                }
                else if(input.equals("-")){
                    if(front.isEmpty()) continue;
                    front.pop();
                }
                else {
                    front.push(input);
                }
            }

            while(!front.isEmpty()){
                back.push(front.pop());
            }
            while (!back.isEmpty()) {
                sb.append(back.pop());
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
