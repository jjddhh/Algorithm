import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int[] arr = new int[51];

    private static int n, m;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int idx = queue.indexOf(arr[i]);

            while(queue.get(0) != arr[i]){
                if (idx < queue.size() - idx) {
                    queue.add(queue.get(0));
                    queue.remove(0);
                    cnt++;
                } else {
                    queue.add(0, queue.get(queue.size() - 1));
                    queue.remove(queue.size() - 1);
                    cnt++;
                }
            }
            queue.remove(0);
        }

        System.out.println(cnt);
    }
}
