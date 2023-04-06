import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int a, b, c, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int work = 0;
        int health = 0;
        for(int i = 0; i < 24; i++) {
            if(health + a <= m) {
                health += a;
                work += b;
            } else {
                health -= c;
                if(health < 0) health = 0;
            }
        }

        System.out.println(work);
    }
}