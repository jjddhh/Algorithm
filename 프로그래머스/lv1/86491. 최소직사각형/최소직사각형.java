class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max = 0;
        int max_idx = 0;
        int max_seq = 0;
        for(int i = 0; i < sizes.length; i++) {
            if(max < sizes[i][0]) {
                max = sizes[i][0];
                max_idx = i;
                max_seq = 0;
            }
            if(max < sizes[i][1]) {
                max = sizes[i][1];
                max_idx = i;
                max_seq = 1;
            }
        }
        
        for(int i = 0; i < sizes.length; i++) {
            if(i == max_idx) continue;
            if(sizes[i][max_seq] < sizes[i][1 - max_seq]) sizes[i][1 - max_seq] = sizes[i][max_seq];
        }
        
        int ano_max = 0;
        for(int i = 0; i < sizes.length; i++) {
            ano_max = Math.max(ano_max, sizes[i][1 - max_seq]);
        }
        
        answer = max * ano_max;
        
        return answer;
    }
}