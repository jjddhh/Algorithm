/*
 * 17087 - 숨바꼭질 6
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(s - Integer.parseInt(st.nextToken()));
        }

        int d = arr[0];
        for (int i = 1; i < n; i++) {
            d = gcd(Math.max(d, arr[i]), Math.min(d, arr[i]));
        }

        System.out.println(d);

        br.close();
    }

    private static int gcd(int fir, int sec) {
        if(fir % sec != 0) return gcd(sec, fir % sec);
        else return sec;
    }
}
