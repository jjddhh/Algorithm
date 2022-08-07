/*
 * 2309 - 일곱 난쟁이
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] length = new int[10];
        int[] seven = new int[8];

        for (int i = 1; i <= 9; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= 8; i++) {

            int sum = 0;

            for (int j = i + 1; j <= 9; j++) {

                int count = 1;
                sum = 0;

                for (int k = 1; k <= 9; k++) {
                    if(k != i && k != j) {
                        seven[count++] = length[k];
                        sum += length[k];
                    }
                }

                if(sum == 100) break;
            }

            if(sum == 100) break;
        }

        Arrays.sort(seven);

        for (int i = 1; i <= 7; i++) {
            sb.append(seven[i]).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
