import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[] dna = new String[n];
        for(int i = 0; i < n; i++) {
            dna[i] = br.readLine();
        }

        char[] arr = {'A', 'C', 'G', 'T'};

        int hd = 0;
        for(int i = 0; i < m; i++) {
            int[] cnt = new int[4];
            for(int j = 0; j < n; j++) {
                char nt = dna[j].charAt(i);
                switch (nt) {
                    case 'A':
                        cnt[0]++;
                        break;
                    case 'C':
                        cnt[1]++;
                        break;
                    case 'G':
                        cnt[2]++;
                        break;
                    case 'T':
                        cnt[3]++;
                        break;
                }
            }

            int max = 0;
            for(int j = 0; j < 4; j++) {
                max = Math.max(max, cnt[j]);
            }

            for(int j = 0; j < 4; j++) {
                if(max == cnt[j]){
                    sb.append(arr[j]);
                    hd += n - cnt[j];
                    break;
                }
            }
        }
        sb.append('\n').append(hd);

        System.out.println(sb);
    }
}