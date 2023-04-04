import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] vert = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            vert[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            vert[edge[i][0]].add(edge[i][1]);
            vert[edge[i][1]].add(edge[i][0]);
        }
        
        int[] dj = new int[n + 1];
        Arrays.fill(dj, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dj[1] = 0;
        pq.add(new Node(1, 0));
        
        int max = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.dist > dj[cur.to]) continue;
            
            for(Integer t : vert[cur.to]) {
                if(cur.dist + 1 < dj[t]) {
                    dj[t] = cur.dist + 1;
                    max = Math.max(max, dj[t]);
                    pq.add(new Node(t, dj[t]));
                }
                
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(dj[i] == max) answer++;
        }
        
        return answer;
    }
    
    class Node implements Comparable<Node>{
        int to;
        int dist;
        
        Node (int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
        
        public int compareTo(Node target) {
            return dist - target.dist;
        }
    }
}