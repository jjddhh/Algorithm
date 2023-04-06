import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m, cnt;
    private static boolean[] visit = new boolean[10];
    private static int[][] arr = new int[101][3];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(cnt);
    }

    static void dfs(int num) {
        if(num > 100) {
            for(int i = 0; i < n; i++) {
                int strike = 0;
                int ball = 0;

                int a = num;
                for(int j = 0; j < 3; j++) {
                    int b = arr[i][0];
                    for(int k = 0; k < 3; k++) {
                        if(a % 10 == b % 10) {
                            if(j == k) strike++;
                            else ball++;
                        }

                        b /= 10;
                    }

                    a /= 10;
                }

                if(strike != arr[i][1] || ball != arr[i][2]) return;
            }

            cnt++;
            return;
        }

        for(int i = 1; i <= 9; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            dfs(num * 10 + i);
            visit[i] = false;
        }
    }
}