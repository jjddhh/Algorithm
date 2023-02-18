import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, k;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            k = Integer.parseInt(br.readLine());
            if(k != 0) stack.push(k);
            else if(!stack.isEmpty()) stack.pop();
            n--;
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
