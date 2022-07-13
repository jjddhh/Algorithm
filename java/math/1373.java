/*
 * 1373 - 2진수 8진수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder out = new StringBuilder();

        String bin = br.readLine();
        int len = bin.length();
        if (len % 3 != 0) {
            for (int i = 0; i < (3 - len % 3); i++) {
                bin = "0" + bin;
            }
        }

        int i = 0;
        while (i < bin.length()) {
            int value = bin.charAt(i++) - '0';
            int sum = value * 4;
            value = bin.charAt(i++) - '0';
            sum += value * 2;
            value = bin.charAt(i++) - '0';
            sum += value * 1;
            sb.append(sum);
        }

        System.out.println(sb);

        br.close();
    }
}
