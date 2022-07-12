/*
 * 9613 - GCD 합
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Long num = Long.parseLong(br.readLine());
        for (Long i = 0L; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            
            int count = Integer.parseInt(st.nextToken());
            Long arr[] = new Long[count];
            for (int sub_i = 0; sub_i < count; sub_i++) {
                arr[sub_i] = Long.parseLong(st.nextToken());
            }

            Long sum = 0L;
            for (int j = 0; j < count - 1; j++) {
                for (int sub_j = j + 1; sub_j < count; sub_j++) {
                    sum += gcd(arr[j], arr[sub_j]);
                }
            }
            
            sb.append(sum).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    private static Long gcd(Long fir, Long sec) {
        if(fir % sec != 0) return gcd(sec, fir % sec);
        else return sec;
    }
}
