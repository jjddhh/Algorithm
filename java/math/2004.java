/*
 * 2004 - 조합 0의 개수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int twoCount = getCount(n, 2) - (getCount(m, 2) + getCount(n-m, 2));
        int fiveCount = getCount(n, 5) - (getCount(m, 5) + getCount(n-m, 5));

        System.out.println(Math.min(twoCount, fiveCount));

        br.close();
    }

    private static int getCount(int num, int div) {
        int count = 0;

        while (num / div > 0) {
            count += num / div;
            num /= div;
        }

        return count;
    }
}
