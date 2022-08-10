/*
 * 1107 - 리모컨
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] remote = new int[10];
        Arrays.fill(remote, 1);

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                remote[Integer.parseInt(st.nextToken())] = 0;
            }
        }

        // 숫자 버튼 누르지 않고 +/- 버튼으로만 움직이는 경우
        int min = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String temp = String.valueOf(i);
            int check = 1;

            for (int j = 0; j < temp.length(); j++) {
                // 자리수
                int index = (temp.charAt(j)) - '0';
                // 망가진 버튼 숫자인지 확인
                if(remote[index] == 0){
                    check = 0;
                    break;
                }
            }

            // 누를 수 있는 숫자라면 누른 후에, +/- 누른 횟수 더한 뒤 여지껏 나온 최소값과 비교
            if (check == 1) {
                min = Math.min(min, temp.length() + Math.abs(i - N));
            }
        }

        System.out.println(min);

        br.close();
    }
}