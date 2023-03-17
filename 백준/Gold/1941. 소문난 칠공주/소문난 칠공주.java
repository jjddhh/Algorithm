import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int cnt;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] combX = new int[25];
    static int[] combY = new int[25];
    private static char[][] seat = new char[6][6];
    private static int[] combination = new int[8];
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 5; i++) {
            char[] col = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                seat[i][j] = col[j];
            }
        }

        for(int i=0; i<25; i++){
            combX[i] = i % 5;
            combY[i] = i / 5;
        }

        Combination(new int[7], 0,0);

        System.out.println(cnt);
    }

    private static void Combination(int[] combination, int idx, int count) {
        if(idx >= 7){
            BFS(combination);
            return;
        }

        if(count == 25) return;

        combination[idx] = count;
        Combination(combination,idx + 1, count + 1);
        Combination(combination, idx,count + 1);
    }

    private static void BFS(int[] combination) {

        int s = 0, y = 0;
        visit = new boolean[8];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(combination[0]);
        visit[0] = true;

        if(seat[combY[combination[0]]][combX[combination[0]]] == 'S') s++;
        else y++;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tx = combX[poll] + dx[i];
                int ty = combY[poll] + dy[i];

                for (int j = 1; j < 7; j++) {
                    int cx = combX[combination[j]];
                    int cy = combY[combination[j]];
                    if(cx == tx && cy == ty && !visit[j]) {
                        if(seat[cy][cx] == 'S') s++;
                        else y++;
                        visit[j] = true;
                        queue.add(combination[j]);
                    }
                }
            }
        }
        for (int j = 0; j < 7; j++) {
            if(!visit[j]) return;
        }
        if(s > y) cnt++;
    }
}