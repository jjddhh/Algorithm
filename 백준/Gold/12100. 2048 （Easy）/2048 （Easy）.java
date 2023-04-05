import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n;
    private static int max;

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[21][21];
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0, arr);

        System.out.println(max);
    }

    static void dfs(int depth, int[][] arr) {
        if(depth == 5) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    max = Math.max(max, arr[i][j]);
                }
            }
            return;
        }

        // 위
        int[][] up = copy(arr);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(up[j][i] == 0) continue;

                for(int k = j + 1; k < n; k++) {
                    if(up[k][i] == 0) continue;
                    if(up[k][i] != up[j][i]) break;

                    up[j][i] *= 2;
                    up[k][i] = 0;
                    break;
                }
            }

            for(int j = 0; j < n - 1; j++) {
                if(up[j][i] != 0) continue;

                for(int k = j + 1; k < n; k++) {
                    if(up[k][i] != 0) {
                        up[j][i] = up[k][i];
                        up[k][i] = 0;
                        break;
                    }
                }
            }
        }

        dfs(depth + 1, up);

        // 아래
        int[][] down = copy(arr);
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j > 0; j--) {
                if(down[j][i] == 0) continue;

                for(int k = j - 1; k >= 0; k--) {
                    if(down[k][i] == 0) continue;
                    if(down[k][i] != down[j][i]) break;

                    down[j][i] *= 2;
                    down[k][i] = 0;
                    break;
                }
            }

            for(int j = n - 1; j > 0; j--) {
                if(down[j][i] != 0) continue;

                for(int k = j - 1; k >= 0; k--) {
                    if(down[k][i] != 0) {
                        down[j][i] = down[k][i];
                        down[k][i] = 0;
                        break;
                    }
                }
            }
        }
        dfs(depth + 1, down);

        // 왼쪽
        int[][] left = copy(arr);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(left[i][j] == 0) continue;

                for(int k = j + 1; k < n; k++) {
                    if(left[i][k] == 0) continue;
                    if(left[i][k] != left[i][j]) break;

                    left[i][j] *= 2;
                    left[i][k] = 0;
                    break;
                }
            }

            for(int j = 0; j < n - 1; j++) {
                if(left[i][j] != 0) continue;

                for(int k = j + 1; k < n; k++) {
                    if(left[i][k] != 0) {
                        left[i][j] = left[i][k];
                        left[i][k] = 0;
                        break;
                    }
                }
            }
        }
        dfs(depth + 1, left);

        // 오른쪽
        int[][] right = copy(arr);
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j > 0; j--) {
                if(right[i][j] == 0) continue;

                for(int k = j - 1; k >= 0; k--) {
                    if(right[i][k] == 0) continue;
                    if(right[i][k] != right[i][j]) break;

                    right[i][j] *= 2;
                    right[i][k] = 0;
                    break;
                }
            }

            for(int j = n - 1; j > 0; j--) {
                if(right[i][j] != 0) continue;

                for(int k = j - 1; k >= 0; k--) {
                    if(right[i][k] != 0) {
                        right[i][j] = right[i][k];
                        right[i][k] = 0;
                        break;
                    }
                }
            }
        }
        dfs(depth + 1, right);
    }

    public static int[][] copy(int[][] src) {
        int[][] copy = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = Arrays.copyOf(src[i], src[i].length);
        }

        return copy;
    }
}