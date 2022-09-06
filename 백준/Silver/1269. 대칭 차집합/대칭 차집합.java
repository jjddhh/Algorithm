import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static HashSet<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }

        System.out.println(set.size());

        br.close();
    }
}