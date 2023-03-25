import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // hashset에 넣고
        HashMap<String, HashSet<String>> reporting = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            reporting.put(id_list[i], new HashSet<>());
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] man = report[i].split(" ");
            reporting.get(man[0]).add(man[1]);
        }
        
        // hashset 순회하면서 새로운 hashmap에 신고 당한 횟수 갱신
        HashMap<String, Integer> reported = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            reported.put(id_list[i], 0);
        }
        
        for(int i = 0; i < id_list.length; i++) {
            Iterator<String> iterator = reporting.get(id_list[i]).iterator();
            
            while(iterator.hasNext()) {
                
                String reported_man = iterator.next();
                reported.put(reported_man, reported.get(reported_man) + 1);
            }
        }
        
        HashMap<String, Integer> report_count = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            report_count.put(id_list[i], 0);
        }
        
        for(int i = 0; i < id_list.length; i++) {
            Iterator<String> iterator = reporting.get(id_list[i]).iterator();
            while(iterator.hasNext()) {
                String reported_man = iterator.next();
                if(reported.get(reported_man) >= k) {
                    report_count.put(id_list[i], report_count.get(id_list[i]) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = report_count.get(id_list[i]);
        }
        
        return answer;
    }
}