import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] arr = new int[401][5];
    static int[][] seat = new int[21][21];

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int a = 0; a < n * n; a++) {

            PriorityQueue<Seat> queue = new PriorityQueue<>();
            // 1번 조사
            int like_max = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(seat[i][j] != 0) continue;
                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int tx = dx[k] + j;
                        int ty = dy[k] + i;

                        if(tx < 0 || tx >= n || ty < 0 || ty >= n || seat[ty][tx] == 0) continue;

                        for(int r = 1; r <= 4; r++) {
                            if(arr[a][r] == seat[ty][tx]) {
                                cnt++;
                                break;
                            }
                        }
                    }
                    like_max = Math.max(like_max, cnt);
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(seat[i][j] != 0) continue;
                    int people_cnt = 0;
                    int empty_cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int tx = dx[k] + j;
                        int ty = dy[k] + i;

                        if(tx < 0 || tx >= n || ty < 0 || ty >= n) continue;
                        if(seat[ty][tx] == 0) {
                            empty_cnt++;
                            continue;
                        }

                        for(int r = 1; r <= 4; r++) {
                            if(arr[a][r] == seat[ty][tx]) {
                                people_cnt++;
                                break;
                            }
                        }
                    }

                    if(people_cnt == like_max) queue.add(new Seat(j, i, empty_cnt));
                }
            }

            Seat std = queue.poll();
            seat[std.y][std.x] = arr[a][0];
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = 0;
                for(int k = 0; k < n * n; k++) {
                    if(arr[k][0] == seat[i][j]) {
                        num = k;
                        break;
                    }
                }

                int people_cnt = 0;
                for(int k = 0; k < 4; k++) {
                    int tx = dx[k] + j;
                    int ty = dy[k] + i;

                    if(tx < 0 || tx >= n || ty < 0 || ty >= n) continue;
                    for(int r = 1; r <= 4; r++) {
                        if(arr[num][r] == seat[ty][tx]) {
                            people_cnt++;
                            break;
                        }
                    }
                }

                max += ((int) Math.pow(10, people_cnt) / 10);
            }
        }

        System.out.println(max);
    }

    static class Seat implements Comparable<Seat>{
        int x, y;
        int empty_seat;

        public Seat(int x, int y, int empty_seat) {
            this.x = x;
            this.y = y;
            this.empty_seat = empty_seat;
        }

        @Override
        public int compareTo(Seat o) {
            if(o.empty_seat != empty_seat) return o.empty_seat - empty_seat;
            else if(o.y != y) return y - o.y;
            else return x - o.x;
        }
    }
}