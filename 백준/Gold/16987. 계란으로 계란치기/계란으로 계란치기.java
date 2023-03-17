import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, mx, cnt;
    private static Egg[] eggs = new Egg[301];

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        bt(0);

        System.out.println(mx);
    }

    private static void bt(int k) {
        if (k >= n) {
            mx = Math.max(mx, cnt);
            return;
        }

        if (eggs[k].s <= 0 || cnt == (n - 1)) {
            bt(k + 1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(i == k || eggs[i].s <= 0) continue;
            eggs[k].s -= eggs[i].w;
            eggs[i].s -= eggs[k].w;
            if(eggs[k].s <= 0) cnt++;
            if(eggs[i].s <= 0) cnt++;
            bt(k + 1);
            if(eggs[k].s <= 0) cnt--;
            if(eggs[i].s <= 0) cnt--;
            eggs[k].s += eggs[i].w;
            eggs[i].s += eggs[k].w;
        }
    }

    static class Egg {
        public int s;
        public int w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}