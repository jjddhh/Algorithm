import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> listIterator = list.listIterator();
        String temp = br.readLine();

        for (char c : temp.toCharArray()) {
            listIterator.add(c);
        }

        int input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "P":
                    listIterator.add((st.nextToken()).charAt(0));
                    break;
                case "L":
                    if(listIterator.hasPrevious()) listIterator.previous();
                    break;
                case "D":
                    if(listIterator.hasNext()) listIterator.next();
                    break;
                case "B":
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
            }
        }

        for (char c : list) {
            sb.append(c);
        }

        // 위의 식과 성능상의 차이 있다.
        //for(int i = 0; i < list.size(); i++){
        //    sb.append(list.get(i));
        //}

        System.out.println(sb);
    }
}
