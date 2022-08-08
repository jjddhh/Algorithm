/*
 * 3085 - 사탕 게임
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static int N;
    public static int max;
    public static Character[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new Character[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= N; j++) {
                arr[i][j] = str.charAt(j - 1);
            }
        }

        for (int i = 1; i <= N; i++) {

            Character temp;
            for (int j = 1; j <= N - 1; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = temp;

                search();

                // 복구
                temp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = temp;
            }

            if (i != N) {
                for (int j = 1; j <= N; j++) {
                    temp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = temp;

                    search();

                    // 복구
                    temp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = temp;
                }
            }
        }

        System.out.println(max);

        br.close();
    }

    private static void search() {
        // 가로
        for(int i = 1; i <= N; i++) {
            int cnt = 1;
            for(int j = 1; j <= N-1; j++) {
                if(arr[i][j] == arr[i][j+1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 세로
        for(int i = 1; i <= N; i++) {
            int cnt = 1;
            for(int j = 1; j <= N-1; j++) {
                if(arr[j][i] == arr[j+1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
    }
}

    

