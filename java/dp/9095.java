/*
 * 9095 - 1, 2, 3 더하기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int k = Integer.parseInt(br.readLine());

            int[] arr = new int[k + 3];
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;

            for (int sub_i = 4; sub_i <= k; sub_i++) {
                arr[sub_i] = arr[sub_i - 1] + arr[sub_i - 2] + arr[sub_i - 3];
            }

            sb.append(arr[k]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
