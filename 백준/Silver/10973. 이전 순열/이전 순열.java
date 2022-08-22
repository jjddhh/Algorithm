import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] input;
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N + 1];
        input = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (seq()) {
            for (int i = 1; i <= N; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);

        br.close();
    }

    private static boolean seq() {
        int i = N;

        //1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다.
        while(i > 1 && arr[i-1] < arr[i]) {
            i -= 1;
        }

        //i의 위치가 0이면 내림차순(마지막 순열)
        if(i <= 1) return false;

        int j = N;

        //2. j >= i 이면서 A[j] > A[i-1] 을 만족하는 가장 큰 j를 찾는다.
        while(arr[j] > arr[i - 1]) {
            j -= 1;
        }

        //3. A[i-1]과 A[j] 를 swap 한다.
        int temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;

        j = N;

        //4. A[i] 부터 순열을 뒤집는다.
        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}