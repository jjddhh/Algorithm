/*
 * 11653 - 소인수분해
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for(int i = 2; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
                sb.append(i).append('\n');
                num /= i;
            }
        }

        if (num != 1) {
            sb.append(num);
        }

        System.out.println(sb);
        br.close();
    }
}
