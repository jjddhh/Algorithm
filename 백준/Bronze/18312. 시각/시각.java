import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, t;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        String tg = String.valueOf(t);
        int cnt = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= 59; j++) {
                for(int k = 0; k <= 59; k++) {
                    String h = String.valueOf(i);
                    if(i < 10) h = "0" + h;
                    if(h.contains(tg)) {
                        cnt++;
                        continue;
                    }

                    String m = String.valueOf(j);
                    if(j < 10) m = "0" + m;
                    if(m.contains(tg)) {
                        cnt++;
                        continue;
                    }

                    String s = String.valueOf(k);
                    if(k < 10) s = "0" + s;
                    if(s.contains(tg)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}