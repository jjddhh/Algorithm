/*
 * 1476 - 날짜 계산
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e, s, m, year;
        year = e = s = m = 1;

        while ((E == e && S == s && M == m) == false) {
            e++; s++; m++;

            if(e % 16 == 0) e = 1;
            if(s % 29 == 0) s = 1;
            if(m % 20 == 0) m = 1;

            year++;
        }

        System.out.println(year);

        br.close();
    }
}