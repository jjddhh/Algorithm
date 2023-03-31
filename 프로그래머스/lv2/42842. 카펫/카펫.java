class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i * i <= yellow; i++) {
            if(yellow % i == 0) {
                int width = Math.max(i, yellow / i);
                int height = Math.min(i, yellow / i);
                int sum = (width * 2) + (height * 2) + 4;
                
                if(sum == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                }
            }
        }
        
        return answer;
    }
}