import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[101][101];
    static boolean[] visit = new boolean[101];

    public static void main(String[] args) throws IOException {
        int r, c, k;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(arr[r][c] == k) {
            System.out.println(0);
            return;
        }

        int time = 1;
        int row_max = 3;
        int col_max = 3;
        while (time <= 100) {
            if (row_max >= col_max) {
                for (int i = 1; i <= row_max; i++) {
                    PriorityQueue<Num> pq = new PriorityQueue<>();
                    visit = new boolean[101];

                    for (int j = 1; j <= col_max; j++) {
                        if(visit[arr[i][j]] || arr[i][j] == 0) continue;
                        visit[arr[i][j]] = true;

                        int count = 0;
                        for (int t = j; t <= col_max; t++) {
                            if(arr[i][j] == arr[i][t]) {
                                count++;
                            }
                        }
                        pq.add(new Num(arr[i][j], count));
                    }

                    Arrays.fill(arr[i], 0);
                    for (int j = 1; j <= 99; j += 2) {
                        if(pq.isEmpty()) break;
                        Num poll = pq.poll();
                        arr[i][j] = poll.num;
                        arr[i][j + 1] = poll.cnt;
                        col_max = Math.max(col_max, j + 1);
                    }
                }

            } else {
                for (int i = 1; i <= col_max; i++) {
                    PriorityQueue<Num> pq = new PriorityQueue<>();
                    visit = new boolean[101];

                    for (int j = 1; j <= row_max; j++) {
                        if(visit[arr[j][i]] || arr[j][i] == 0) continue;
                        visit[arr[j][i]] = true;

                        int count = 0;
                        for (int t = j; t <= row_max; t++) {
                            if(arr[j][i] == arr[t][i]) {
                                count++;
                            }
                        }

                        pq.add(new Num(arr[j][i], count));
                    }

                    for (int j = 1; j <= 100; j++) {
                        arr[j][i] = 0;
                    }

                    for (int j = 1; j <= 99; j += 2) {
                        if(pq.isEmpty()) break;
                        Num poll = pq.poll();
                        arr[j][i] = poll.num;
                        arr[j + 1][i] = poll.cnt;
                        row_max = Math.max(row_max, j + 1);
                    }
                }
            }

            if(arr[r][c] == k) break;
            time++;
        }

        if(time > 100) time = -1;

        System.out.println(time);
    }

    static class Num implements Comparable<Num> {
        int num;
        int cnt;

        public Num(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Num o) {
            if(cnt != o.cnt) return cnt - o.cnt;
            return num - o.num;
        }
    }
}