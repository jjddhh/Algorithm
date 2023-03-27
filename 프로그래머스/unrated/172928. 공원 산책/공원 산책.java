class Solution {
    
    char[][] arr = new char[51][51];
    
    public int[] solution(String[] park, String[] routes) {
        
        int c = 0, r = 0;
        int w = park[0].length();
        int h = park.length;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                arr[i][j] = park[i].charAt(j);
                if(arr[i][j] == 'S') {
                    c = i;
                    r = j;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++) {
            String[] mov = routes[i].split(" ");
            int dist = Integer.parseInt(mov[1]);
            boolean wall = false;
            
            switch (mov[0]) {
                case "E":
                    if(r + dist >= w) break;
                    
                    for(int j = 1; j <= dist; j++) {
                        if(arr[c][r + j] == 'X') {
                            wall = true;
                            break;
                        }
                    }
                    if(wall) break;

                    r += dist;
                    break;
                case "W":
                    if(r - dist < 0) break;
                  
                    for(int j = 1; j <= dist; j++) {
                        if(arr[c][r - j] == 'X') {
                            wall = true;
                            break;
                        }
                    }
                    if(wall) break;

                    r -= dist;
                    break;
                case "N":
                    if(c - dist < 0) break;
                  
                    for(int j = 1; j <= dist; j++) {
                        if(arr[c - j][r] == 'X') {
                            wall = true;
                            break;
                        }
                    }
                    if(wall) break;

                    c -= dist;
                    break;
                default:
                    if(c + dist >= h) break;
                   
                    for(int j = 1; j <= dist; j++) {
                        if(arr[c + j][r] == 'X') {
                            wall = true;
                            break;
                        }
                    }
                    if(wall) break;

                    c += dist;
            }
        }
        
        int[] answer = {c, r};
        return answer;
    }
}