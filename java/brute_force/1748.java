/*
 * 1748 - 수 이어 쓰기 1
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int std = 10;
        int length = 0;
        for (int i = 1; i <= N; i++) {
            if (i == std) {
                std *= 10;
                count++;
            }
            length += count;
        }

        System.out.println(length);

        br.close();
    }
}