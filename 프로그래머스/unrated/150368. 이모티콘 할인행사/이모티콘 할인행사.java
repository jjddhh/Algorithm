import java.util.*;

class Solution {
    PriorityQueue<Register> pq = new PriorityQueue<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < users.length; i++) {
            set.add(users[i][0]);
        }
        
        int[] percent = new int[emoticons.length];
        dfs(0, emoticons, percent, users);
        
        Register max = pq.poll();
        int[] answer = new int[2];
        answer[0] = max.mem;
        answer[1] = max.sales;
        
        return answer;
    }
    
    void dfs(int depth, int[] emoticons, int[] percent, int[][] users) {
        if(depth == emoticons.length) {
            int mem = 0;
            int sales = 0;
            for(int i = 0; i < users.length; i++) {
                
                int sum = 0;
                for(int j = 0; j < emoticons.length; j++) {
                    if(users[i][0] <= percent[j]) {
                        sum += (emoticons[j] / 100) * (100 - percent[j]);
                    }
                }
                
                if(sum >= users[i][1]) mem++;
                else sales += sum;
            }

            pq.add(new Register(mem, sales));
            
            return;
        }
        
        for(int i = 10; i <= 40; i += 10) {
            percent[depth] = i;
            dfs(depth + 1, emoticons, percent, users);
        }
    }
    
    class Register implements Comparable<Register> {
        public int mem;
        public int sales;
        
        Register(int mem, int sales) {
            this.mem = mem;
            this.sales = sales;
        }
        
        public int compareTo(Register t) {
            if(this.mem != t.mem) return t.mem - this.mem;
            else return t.sales - this.sales;
        }
    }
}