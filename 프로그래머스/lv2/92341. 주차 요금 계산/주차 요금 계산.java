import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        HashMap<Integer, Integer> timeMap = new HashMap<>();
        for(int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            timeMap.put(Integer.parseInt(arr[1]), 0);
        }
        
        for(int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            int carNum = Integer.parseInt(arr[1]);
            if(arr[2].equals("IN")) {
                hashMap.put(carNum, arr[0]);
            } else {
                String[] inTime = hashMap.get(carNum).split(":");
                int inMin = Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]);
                
                String[] outTime = arr[0].split(":");
                int outMin = Integer.parseInt(outTime[0]) * 60 + Integer.parseInt(outTime[1]);
                int min = outMin - inMin;
                hashMap.remove(carNum);
                
                timeMap.put(carNum, timeMap.get(carNum) + min);
            }            
        }
        
        Set<Integer> remain = hashMap.keySet();
        Iterator<Integer> remainIterator = remain.iterator();
        while(remainIterator.hasNext()) {
            int num = remainIterator.next();
            
            String[] inTime = hashMap.get(num).split(":");
            int inMin = Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]);
            
            String[] outTime = "23:59".split(":");
            int outMin = Integer.parseInt(outTime[0]) * 60 + Integer.parseInt(outTime[1]);
            int min = outMin - inMin;
            
            timeMap.put(num, timeMap.get(num) + min);
        }
        
        List<Integer> keys = new ArrayList<>(timeMap.keySet());
        Collections.sort(keys);
        
        int[] answer = new int[keys.size()];
        
        int keySize = keys.size();
        for(int i = 0; i < keySize; i++) {
            int num = keys.get(i);
            
            int min = timeMap.get(num);
            
            int fee;
            if(min - fees[0] < 0) fee = fees[1];
            else {
                fee = fees[1] + ((min - fees[0]) / fees[2]) * fees[3];
                if(((min - fees[0]) % fees[2]) > 0) fee += fees[3];
            }
            
            answer[i] = fee;
        }
        
        return answer;
    }
}