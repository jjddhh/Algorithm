/*
 * 6588 - 골드바흐의 추측
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Boolean[] arr = new Boolean[1000001];
        Arrays.fill(arr, false);

        for (int i = 3; i < 1000001; i++) if(isPrime(i)) arr[i] = true;

        while (true) {
            int num = Integer.parseInt(br.readLine());
            int check = 1;

            if(num == 0) break;

            for (int i = 3; i <= num - 3; i++) {
                if (arr[i] && arr[num - i]) {
                    sb.append(num + " = " + i + " + " + (num - i)).append('\n');
                    check = 0;
                    break;
                }
            }

            if(check == 1) sb.append("Goldbach's conjecture is wrong.").append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    private static Boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
