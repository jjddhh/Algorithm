import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] sum = new String[2];

        for (int i = 0; i < 2; i++) {
            sum[i] = st.nextToken() + st.nextToken();
        }

        long temp = Long.parseLong(sum[0]) + Long.parseLong(sum[1]);

        System.out.println(temp);

        br.close();
    }
}
