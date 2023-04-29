// 앞에다 0을 추가하는 것 까지는 인지.
// 이진 트리 검사하는 법 미숙

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int[] treeSize = {1, 3, 7, 15, 31, 63, 127};
        
        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            StringBuilder binary = new StringBuilder();
            // 이진법 변환
            while(num > 0) {
                binary.append(num % 2);
                num /= 2;
            }
            
            // 포화 이진 트리로 조정
            // int len = binary.length();
            // for(int j = 1; j < 7; j++){
            //     if(treeSize[j] - 1 == len) {
            //         binary.append(0);
            //         break;
            //     }
            // }
            int len = binary.length();
            int cnt = 0;
            while((int)Math.pow(2, cnt) - 1 < len) cnt++;
            while((int)Math.pow(2, cnt) - 1 != binary.length()) binary.append(0);
            
            binary.reverse();

            // System.out.println(binary.length());
            
            if(treeCheck(binary.toString())) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
    
    boolean treeCheck(String tree) {
        boolean isValid = true;
        int mid = (tree.length() - 1) / 2;
        Character root = tree.charAt(mid);
        String left = tree.substring(0, mid);
        String right = tree.substring(mid + 1, tree.length());
        
        if(root == '0' && 
           (left.charAt((left.length() - 1) / 2) == '1' || right.charAt((right.length() - 1) / 2) == '1')) {
            return false;
        }
        
        if(left.length() >= 3) {
            isValid = treeCheck(left);
            if(isValid) isValid = treeCheck(right);
        }
        
        return isValid;
    }
}