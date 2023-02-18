import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int a, b, c;
    private static int[] arr = new int[10];
    private static char op;

    public static void main(String[] args) throws IOException {

        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        int sum = a * b * c;
        char[] str = String.valueOf(sum).toCharArray();
        for (int i = 0; i < str.length; i++) {
            arr[Integer.parseInt(String.valueOf(str[i]))]++;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
