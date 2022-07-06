/*
 * 11655 - ROT13
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);

            if('a' <= temp && temp <= 'z'){
                if(temp + 13 > 'z'){
                    int gap = temp + 13 - 'z';
                    sb.append((char)('a' + gap - 1));
                }else sb.append((char)(temp + 13));
                
            } else if('A' <= temp && temp <= 'Z') {
                if (temp + 13 > 'Z') {
                    int gap = temp + 13 - 'Z';
                    sb.append((char) ('A' + gap - 1));
                } else sb.append((char) (temp + 13));
                
            }else sb.append(temp);
        }

        System.out.println(sb);

        br.close();
    }
}
