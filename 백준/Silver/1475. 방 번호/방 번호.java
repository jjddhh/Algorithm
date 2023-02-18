import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int a, b, c;
    private static double[] arr = new double[10];
    private static char op;

    public static void main(String[] args) throws IOException {

        a = Integer.parseInt(br.readLine());

        int mod = 0;
        while (a > 0) {
            mod = a % 10;
            if(mod == 6 || mod == 9) arr[6] += 0.5;
            else arr[a % 10]++;

            a /= 10;
        }

        double max = 0;
        for (int i = 0; i < 10; i++) {
            if(arr[i] > max) max = arr[i];
        }

        System.out.println((int)Math.round(max));
    }
}
