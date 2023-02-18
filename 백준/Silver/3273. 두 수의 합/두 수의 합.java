import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, x, c;
    private static boolean[] arr;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new boolean[2000001];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            arr[Integer.parseInt(st.nextToken())] = true;
        }

        x = Integer.parseInt(br.readLine());

        for (int i = 1; i <= x / 2; i++) {
            if(arr[i] && arr[x - i]) c++;
        }
        if(arr[x / 2] && x % 2 == 0) c--;

        System.out.println(c);
    }
}
