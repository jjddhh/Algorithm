import java.util.Scanner;

public class Main {

    static int size = 0;
    static int[] stack;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int loop = scanner.nextInt();
        stack = new int[loop];
        String op = "";

        for (int i = 0; i < loop; i++) {
            op = scanner.next();
            switch (op) {
                case "push":
                    int num = scanner.nextInt();
                    stack[size++] = num;
                    break;
                case "pop":
                    sb.append(Pop() + "\n");
                    break;
                case "size":
                    sb.append(Size() + "\n");
                    break;
                case "empty":
                    sb.append(Empty() + "\n");
                    break;
                case "top":
                    sb.append(Top() + "\n");
            }
        }

        System.out.println(sb);
    }

    public static int Size(){
        return size;
    }

    public static int Empty() {
        if(size == 0) return 1;
        else return 0;
    }

    public static int Pop() {
        if(size == 0) return -1;
        else return stack[--size];
    }

    public static int Top(){
        if(size == 0) return -1;
        else return stack[size - 1];
    }
}
