import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int a, t, k;

    public static void main(String[] args) throws IOException {
        a = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int bun = 0;
        int dagy = 0;
        int cur = 0;

        for(int i = 1; i <= 10000; i++) {
            for(int j = 0; j < 4; j++) {
                if(j % 2 == 0) {
                    bun++;
                    if(k == 0 && bun == t) {
                        System.out.println(cur);
                        return;
                    }
                    cur = (cur + 1) % a;
                } else {
                    dagy++;
                    if(k == 1 && dagy == t) {
                        System.out.println(cur);
                        return;
                    }
                    cur = (cur + 1) % a;
                }
            }

            for(int j = 0; j < (i + 1); j++) {
                bun++;
                if(k == 0 && bun == t) {
                    System.out.println(cur);
                    return;
                }
                cur = (cur + 1) % a;
            }

            for(int j = 0; j < (i + 1); j++) {
                dagy++;
                if(k == 1 && dagy == t) {
                    System.out.println(cur);
                    return;
                }
                cur = (cur + 1) % a;
            }
        }
    }
}