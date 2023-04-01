import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int answer = 0;
        int boat = 0;
        int j = 0;
        for(int i = people.length - 1; i >= j; i--) {
            answer++;
            boat = people[i];
            // for(; j < i; j++) {
            //     if(boat + people[j] <= limit) {
            //         boat += people[j];
            //     } else {
            //         j--;
            //         break;
            //     }
            // }
            
            while(boat + people[j] <= limit) {
                boat += people[j];
                j++;
            }
            // j--;
            
        }
        
        // int answer = 1;
        // int boat = 0;
        // for(int i = 0; i < people.length; i++) {
        //    if(boat + people[i] <= limit) {
        //        boat += people[i];
        //    } else {
        //        boat = people[i];
        //        answer++;
        //    }
        // }
        
        return answer;
    }
}