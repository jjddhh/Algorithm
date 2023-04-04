import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] flo = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            // Integer.MAX_VALUE 로 설정시 오버플로우 가능성
            Arrays.fill(flo[i], 10000);
        }
        
        for(int i = 0; i < results.length; i++) {
            flo[results[i][0]][results[i][1]] = 1;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(flo[i][j] + "\t");
            }
            System.out.println();
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    flo[i][j] = Math.min(flo[i][j], flo[i][k] + flo[k][j]);
                }
            }
        }
        
        System.out.println();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(flo[i][j] + "\t");
            }
            System.out.println();
        }
        
        int[] cnt = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int total = 0;
            for(int j = 1; j <= n; j++) {
                if(flo[i][j] != 10000) {
                    cnt[j]++;
                    total++;
                }
            }
            cnt[i] += total;
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            System.out.println(i + " : " + cnt[i]);
            if(cnt[i] == n - 1) answer++;
        }
        
        return answer;
    }
}