import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Print> list = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            list.add(new Print(priorities[i], i));
        }
        
        while(!list.isEmpty()) {
            Print fPrint = list.get(0);
            
            boolean flag = false;
            Iterator<Print> it = list.iterator();
            while(it.hasNext()) {
                Print anoPrint = it.next();
                if(fPrint.prior < anoPrint.prior) {
                    list.remove(0);
                    list.add(fPrint);
                    flag = true;
                    break;
                } 
            };
            
            if(!flag) {
                list.remove(0);
                answer++;
                System.out.println(fPrint.prior);
                if(fPrint.loc == location) return answer;
            }
            
        }
        
        return answer;
    }
    
    class Print {
        int prior;
        int loc;
        
        Print (int prior, int loc) {
            this.prior = prior;
            this.loc = loc;
        }
    }
}