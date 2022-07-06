/*
 * 10809 - 알파벳 찾기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            if (alpha[index] == -1) {
                alpha[index] = i;
            }
        }

        for (int i = 0; i < alpha.length; i++) {
            sb.append(alpha[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
