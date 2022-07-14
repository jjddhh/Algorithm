/*
 * 11576 - Base Conversion
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        br.readLine();

        st = new StringTokenizer(br.readLine());

        int n = st.countTokens() - 1;
        int sum = 0;
        while (n >= 0) {
            sum += (int)Math.pow(A, n) * Integer.parseInt(st.nextToken());
            n--;
        }

        while (sum / B > 0) {
            stack.push(sum % B);
            sum /= B;
        }
        stack.push(sum);

        while (stack.isEmpty() == false) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
