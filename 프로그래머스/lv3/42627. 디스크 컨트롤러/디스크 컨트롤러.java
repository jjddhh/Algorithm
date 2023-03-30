import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        
        PriorityQueue<Work> pq = new PriorityQueue<>();
        for(int i = 0; i < jobs.length; i++) {
            pq.add(new Work(jobs[i][0], jobs[i][1]));
        }
        
        int curTime = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            Work curWork = pq.poll();
            
            if(curWork.req > curTime) {
                answer += curWork.work;
                curTime = curWork.req + curWork.work;
            } else {
                List<Work> list = new ArrayList<>();
                list.add(curWork);
                
                while(!pq.isEmpty() && pq.peek().req <= curTime) {
                    list.add(pq.poll());
                }
                
                Collections.sort(list, (o1, o2) -> o1.work - o2.work);
                curWork = list.get(0);
                list.remove(0);
                
                answer += curTime - curWork.req + curWork.work;
                curTime += curWork.work;
                
                pq.addAll(list);
            }
        }
        
        answer = answer / jobs.length;
        
        return answer;
    }
    
    class Work implements Comparable<Work>{
        int req;
        int work;
        
        Work (int req, int work) {
            this.req = req;
            this.work = work;
        }
        
        @Override
        public int compareTo(Work target) {
            if(req != target.req) return req - target.req;
            return work - target.work;
        }
    }
}