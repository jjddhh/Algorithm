class Solution {
    int answer = 0;
    int num[];
    
    public int solution(int[] numbers, int target) {
        num = new int[numbers.length + 1];
        for(int i = 0; i < numbers.length; i++) num[i] = numbers[i];
        
        dfs(0, 0, target);
        
        return answer;
    }
    
    void dfs(int cur, int depth, int target) {
        if(depth == num.length - 1) {
            if(cur == target) answer++;
            return;
        }
        
        dfs(cur + num[depth], depth + 1, target);
        dfs(cur - num[depth], depth + 1, target);
    }
}