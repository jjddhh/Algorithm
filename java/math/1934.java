/*
 * 1934 - 최소공배수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num[];
        
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            num = new int[count];
            for (int sub_i = 0; sub_i < count; sub_i++) {
                num[sub_i] = Integer.parseInt(st.nextToken());
            }

            int max_div = gcd(Math.max(num[0], num[1]), Math.min(num[0], num[1]));
            // 두 수의 곱 = 최소 공약수 * 최소 공배수
            int min_mult = (num[0] * num[1]) / max_div;

            sb.append(min_mult).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    // 유클리드 호제법
    private static int gcd(int max, int min) {
        if(max % min == 0) return min;
        else{
            return gcd(min, max % min);
        }
    }
}
