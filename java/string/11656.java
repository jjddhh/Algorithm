/*
 * 11656 - 접미사 배열
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        String[] arr = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            arr[i] = word.substring(i);
        }

        Arrays.sort(arr);

        for (String m : arr) {
            sb.append(m).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
