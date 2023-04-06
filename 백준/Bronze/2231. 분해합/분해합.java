import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if(sum + i == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}