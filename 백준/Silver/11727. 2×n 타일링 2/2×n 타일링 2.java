import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n;
    private static int[] var = new int[1001];

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        var[1] = 1;
        var[2] = 3;
        for (int i = 3; i <= n; i++) {
            var[i] = (var[i - 1] + (var[i - 2] * 2)) % 10_007;
        }

        System.out.println(var[n] % 10_007);
    }
}