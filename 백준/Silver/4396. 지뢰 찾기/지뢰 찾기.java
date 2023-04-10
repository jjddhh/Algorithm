import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static boolean[][] trap = new boolean[11][11];
    static char[][] ans = new char[11][11];
    static char[][] output = new char[11][11];

    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                trap[i][j] = str.charAt(j) == '.' ? false : true;
            }
        }

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                ans[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(output[i], '.');
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char choice = ans[i][j];
                if(choice != 'x') continue;

                if(trap[i][j]) {
                    for(int k = 0; k < n; k++) {
                        for(int r = 0; r < n; r++) {
                            if(trap[k][r]) output[k][r] = '*';
                        }
                    }
                }else {
                    int trap_cnt = 0;
                    for(int k = 0; k < 8; k++) {
                        int tx = dx[k] + j;
                        int ty = dy[k] + i;

                        if(tx < 0 || tx >= n || ty < 0 || ty >= n) continue;
                        if(trap[ty][tx]) trap_cnt++;
                    }
                    output[i][j] = String.valueOf(trap_cnt).charAt(0);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
    }
}