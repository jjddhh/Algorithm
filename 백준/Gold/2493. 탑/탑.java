import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n;
    private static int arr[] = new int[500001];
    private static int seq[] = new int[500001];

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        Stack<Point> stack = new Stack<>();
        stack.push(new Point(100000001, 0));

        st = new StringTokenizer(br.readLine());
        int k = 1;
        while (st.hasMoreTokens()) {
            arr[k] = Integer.parseInt(st.nextToken());
            k++;
        }

        for (int i = 1; i <= n; i++) {
            while(stack.peek().x < arr[i]) stack.pop();
            sb.append(stack.peek().y).append(" ");
            stack.push(new Point(arr[i], i));
        }

        System.out.println(sb);
    }
}
