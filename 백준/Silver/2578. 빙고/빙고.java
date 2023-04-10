import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] bingo = new int[6][6];
    static int[][] pro = new int[6][6];
    static boolean[][] ans = new boolean[6][6];

    public static void main(String[] args) throws IOException {
        for(int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                pro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 1; i <= 5; i++) {
            for(int j = 1; j <= 5; j++) {
                cnt++;
                int tmp = pro[i][j];

                for(int k = 1; k <= 5; k++) {
                    for(int t = 1; t <= 5; t++) {
                        if(bingo[k][t] == tmp) ans[k][t] = true;
                    }
                }

                int line = 0;
                for(int k = 1; k <= 5; k++) {
                    boolean flag = true;
                    for(int t = 1; t <= 5; t++) {
                        if(!ans[k][t]) flag = false;
                    }
                    if(flag) line++;
                }

                for(int k = 1; k <= 5; k++) {
                    boolean flag = true;
                    for(int t = 1; t <= 5; t++) {
                        if(!ans[t][k]) flag = false;
                    }
                    if(flag) line++;
                }

                boolean flag = true;
                for(int k = 1; k <= 5; k++) {
                    if(!ans[k][k]) flag = false;
                }
                if(flag) line++;

                flag = true;
                for(int k = 1; k <= 5; k++) {
                    if(!ans[k][6 - k]) flag = false;
                }
                if(flag) line++;

                if(line >= 3) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }
}