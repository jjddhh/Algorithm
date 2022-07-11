/*
 * 1676 - 팩토리얼 0의 개수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Long n = Long.parseLong(br.readLine());

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;

            while ((temp % 5) == 0) {
                count++;
                temp = temp / 5;
            }
        }

        System.out.println(count);

        br.close();
    }
}
