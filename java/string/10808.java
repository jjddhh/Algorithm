/*
 * 10808 - 알파벳 개수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alpha = new int[26];
        Arrays.fill(alpha, 0);
        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            alpha[index] += 1;
        }

        for (int i = 0; i < alpha.length; i++) {
            sb.append(alpha[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
