/*
 * 2745 - 진법 변환
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

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            int dec = Character.getNumericValue(N.charAt(i)) ;

            sum += dec * Math.pow(B, N.length() - 1 - i);
        }

        System.out.println(sum);
        br.close();
    }
}
