import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a, b, c;
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sb.append((a + b) % c).append('\n');
        sb.append(((a % c) + (b % c)) % c).append('\n');
        sb.append((a * b) % c).append('\n');
        sb.append(((a % c) * (b % c)) % c).append('\n');

        System.out.println(sb);

        br.close();
    }
}
