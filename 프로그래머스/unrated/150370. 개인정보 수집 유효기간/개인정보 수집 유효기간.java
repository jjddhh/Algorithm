import java.util.*;

class Solution {
    public List solution(String today, String[] terms, String[] privacies) {
        String[] day = new String[privacies.length];
        String[] type = new String[privacies.length];
        for(int i = 0; i < privacies.length; i++) {
            day[i] = privacies[i].split(" ")[0];
            type[i] = privacies[i].split(" ")[1];
        }
        
        int dueDay = convertToDay(today);
        
        List<Integer> answer = new ArrayList<>(100);
        for(int i = 0; i < privacies.length; i++) {
            for(int j = 0; j < terms.length; j++) {
                if(type[i].equals(terms[j].split(" ")[0])) {
                    int storeDay = convertToDay(day[i]) + Integer.parseInt(terms[j].split(" ")[1]) * 28;
                    if(dueDay >= storeDay) answer.add(i + 1);
                    break;
                }
            }
        }

        return answer;
    }
    
    int convertToDay(String today) {
        String[] split = today.split("[.]");
        int yearToDay = Integer.parseInt(split[0]) * 12 * 28;
        int monthToDay = Integer.parseInt(split[1]) * 28;
        int totalDay = yearToDay + monthToDay + Integer.parseInt(split[2]);
        return totalDay;
    }
}