/*
 * 10820 - 문자열 분석
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = "";
        while((S = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            int[] num = new int[4];

            for (int i = 0; i < S.length(); i++) {
                char temp = S.charAt(i);
                if ('a' <= temp && temp <= 'z') num[0]++;
                else if ('A' <= temp && temp <= 'Z') num[1]++;
                else if ('0' <= temp && temp <= '9') num[2]++;
                else num[3]++;
            }

            for (int i = 0; i < num.length; i++) {
                sb.append(num[i]).append(" ");
            }

            System.out.println(sb);
        }

        br.close();
    }
}
