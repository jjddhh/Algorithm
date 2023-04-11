import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, s, e;
    static int[] h = new int[1001];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Work> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        List<Rect> list = new ArrayList<>();

        Work first = pq.poll();
        int start = first.from;
        int end = first.to;
        int height = 1;

        for (int i = start; i <= end; i++) {
            h[i]++;
        }

        while (!pq.isEmpty()) {
            Work work = pq.poll();

            if(work.from > end + 1) {
                list.add(new Rect(end - start + 1, height));

                start = work.from;
                end = work.to;
                height = 1;

                for (int i = start; i <= end; i++) {
                    h[i]++;
                }
            } else {
                for (int i = work.from; i <= work.to; i++) {
                    h[i]++;
                }

                end = Math.max(end, work.to);

                for (int i = start; i <= end; i++) {
                    height = Math.max(height, h[i]);
                }
            }
        }

        list.add(new Rect(end - start + 1, height));

        int sum = 0;
        for (Rect r : list) {
            sum += r.height * r.width;
        }

        System.out.println(sum);
    }

    static class Work implements Comparable<Work> {
        int from, to;

        public Work(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Work o) {
            if(from != o.from) return from - o.from;
            return o.to - to;
        }
    }

    static class Rect {
        int width, height;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}