/*
 * 1463 - 1로 만들기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, n);
        arr[n] = 0;

        for (int i = n; i > 1; i--) {
            if (i % 3 == 0 && (arr[i / 3] > arr[i] + 1)) arr[i / 3] = arr[i] + 1;
            if (i % 2 == 0 && (arr[i / 2] > arr[i] + 1)) arr[i / 2] = arr[i] + 1;
            if (arr[i - 1] > arr[i] + 1) arr[i - 1] = arr[i] + 1;
        }

        System.out.println(arr[1]);
        br.close();
    }
}
