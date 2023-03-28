import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curNode = null;
        
        for(int i = 0; i < n; i++) {
            Node node = new Node(i);
            list.add(node);
            
            if(i == k) curNode = node;
        }
        
        for(int i = 0; i < n; i++) {
            Node node = list.get(i);
            if(i != 0) node.prev = list.get(i - 1);
            if(i != n - 1) node.next = list.get(i + 1);
        }
        
        for(int i = 0; i < cmd.length; i++) {
            String[] tmp = cmd[i].split(" ");
            int loop = 0;
            Node prevNode;
            Node nextNode;
            
            switch(tmp[0]) {
                case "U":
                    loop = Integer.parseInt(tmp[1]);
                    for(int j = 0; j < loop; j++) {
                        curNode = curNode.prev;
                    }
                    break;
                case "D":
                    loop = Integer.parseInt(tmp[1]);
                    for(int j = 0; j < loop; j++) {
                        curNode = curNode.next;
                    }
                    break;
                case "C":
                    curNode.status = false;
                    stack.push(curNode);
                    
                    prevNode = curNode.prev;
                    nextNode = curNode.next;
                    
                    if (nextNode != null && prevNode != null) {
                      prevNode.next = nextNode;
                      nextNode.prev = prevNode;
                      curNode = nextNode;
                    } else if (nextNode == null && prevNode != null) {
                      prevNode.next = nextNode;
                      curNode = prevNode;
                    } else if (nextNode != null && prevNode == null) {
                      nextNode.prev = prevNode;
                      curNode = nextNode;
                    }
                    
                    break;
                default:
                    Node undoNode = stack.pop();
                    undoNode.status = true;
                    
                    prevNode = undoNode.prev;
                    nextNode = undoNode.next;
                    
                    if(prevNode != null) prevNode.next = undoNode;
                    if(nextNode != null) nextNode.prev = undoNode;
            }
            
        }
        
        StringBuilder answer = new StringBuilder("O".repeat(n));

        while(!stack.empty()) {
            Node node = stack.pop();
            answer.setCharAt(node.index, 'X');
        }
        
        return answer.toString();
    }
    
    class Node {
      int index;
      boolean status = true;  
      Node prev = null;
      Node next = null;

      public Node(int index) {
        this.index = index;
      }
    }
}

