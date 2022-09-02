import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] N_arr = new String[N + 1];
        String[] M_arr = new String[M + 1];

        for (int i = 1; i <= N; i++) {
            N_arr[i] = br.readLine();
        }

        for (int i = 1; i <= M; i++) {
            M_arr[i] = br.readLine();
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (N_arr[j].contentEquals(M_arr[i])) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }

}