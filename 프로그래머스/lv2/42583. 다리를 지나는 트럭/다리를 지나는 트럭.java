import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> trucks = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
            trucks.add(truck_weights[i]);
        }
        
        int answer = 0;
        int totalWeight = 0;
        List<Truck> bridge = new LinkedList<>();
        totalWeight += trucks.peek();
        bridge.add(new Truck(bridge_length - 1, trucks.poll()));
        answer++;
        
        while(!bridge.isEmpty()) {
            while(!bridge.isEmpty() && bridge.get(0).dist == 0) {
                totalWeight -= bridge.get(0).weight;
                bridge.remove(0);
                if(truck_weights.length == 10) System.out.println(answer);
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