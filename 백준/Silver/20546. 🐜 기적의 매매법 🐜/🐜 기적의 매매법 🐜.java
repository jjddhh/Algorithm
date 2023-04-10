import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] chart = new int[15];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 14; i++) {
            chart[i] = Integer.parseInt(st.nextToken());
        }

        int bnp = 0;
        int bnp_cash = n;
        for(int i = 1; i <= 14; i++) {
            if(chart[i] <= bnp_cash) {
                bnp = bnp_cash / chart[i];
                bnp_cash = bnp_cash % chart[i];
            }
        }

        int tim = 0;
        int tim_cash = n;
        int seq = 0;
        for(int i = 2; i <= 14; i++) {
            if(chart[i] == chart[i - 1]) seq = 0;
            else if (chart[i] > chart[i - 1]) {
                if(seq < 0) seq = 0;
                seq++;
            } else {
                if(seq > 0) seq = 0;
                seq--;
            }

            if(seq <= -3) {
                tim += tim_cash / chart[i];
                tim_cash = tim_cash % chart[i];
            } else if(seq >= 3) {
                tim_cash += tim * chart[i];
                tim = 0;
            }
        }

        if(tim * chart[14] + tim_cash > bnp * chart[14] + bnp_cash) System.out.println("TIMING");
        else if(tim * chart[14] + tim_cash < bnp * chart[14] + bnp_cash) System.out.println("BNP");
        else System.out.println("SAMESAME");
    }
}