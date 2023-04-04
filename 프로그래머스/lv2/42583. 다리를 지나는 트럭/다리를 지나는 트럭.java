import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 대기 트럭
        Queue<Integer> trucks = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
            trucks.add(truck_weights[i]);
        }
        
        // 다리를 건너는 트럭
        List<Truck> bridge = new LinkedList<>();
        int answer = 0;
        int totalWeight = 0;
        
        totalWeight += trucks.peek();
        bridge.add(new Truck(bridge_length - 1, trucks.poll()));
        answer++;
        
        while(!bridge.isEmpty()) {
            // 맨 앞 트럭이 도착했는지 확인 후 제거
            if(bridge.get(0).dist == 0) {
                totalWeight -= bridge.get(0).weight;
                bridge.remove(0);
            }
            
            if(!trucks.isEmpty()) {
                int truckWeight = trucks.peek();
                if(totalWeight + truckWeight <= weight) {
                    bridge.add(new Truck(bridge_length, trucks.poll()));
                    totalWeight += truckWeight;
                }    
            }   
            
            int len = bridge.size();
            for(int i = 0; i < len; i++) {
                Truck truck = bridge.get(i);
                truck.dist -= 1;
            }
            
            answer++;
        }
        
        return answer;
    }
    
    class Truck {
        int dist;
        int weight;
            
        Truck (int dist, int weight) {
            this.dist = dist;
            this.weight = weight;
        }
    }
}