/*
 * 10872 - 팩토리얼
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int value = factorial(n);

        System.out.println(value);

        br.close();
    }

    private static int factorial(int n) {
        if(n == 0) return 1;
        return n * factorial(n - 1);
    }
}
