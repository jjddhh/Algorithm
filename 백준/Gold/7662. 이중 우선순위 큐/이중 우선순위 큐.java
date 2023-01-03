import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m, val;
    private static char op;
    private static TreeMap<Integer, Integer> treeMap;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                op = st.nextToken().charAt(0);
                val = Integer.parseInt(st.nextToken());

                if (op == 'I') treeMap.put(val, treeMap.getOrDefault(val, 0) + 1);
                else {
                    if(treeMap.isEmpty()) continue;

                    int tmp;
                    if (val == 1) tmp = treeMap.lastKey();
                    else tmp = treeMap.firstKey();

                    if(treeMap.put(tmp, treeMap.get(tmp) - 1) == 1) treeMap.remove(tmp);
                }
            }

            if(treeMap.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");

        }

        System.out.println(sb);
    }
}
