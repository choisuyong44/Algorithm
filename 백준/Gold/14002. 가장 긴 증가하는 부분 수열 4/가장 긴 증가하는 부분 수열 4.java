import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr,dp;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        input();
        if(N==1) {
            System.out.println(1);
            System.out.println(arr[0]);
            return;
        }

        int max =0; int max_idx =0;
        for (int i = 1; i < N; i++) {
            int cnt = 0;
            for(int j = 1; i-j >=0;j++){
                if(arr[i] > arr[i-j]){
                    cnt = Math.max(cnt, dp[i-j]);
                }
            }
            dp[i] = cnt+1;
            if(max < dp[i]){
                max = dp[i];
                max_idx = i;
            }
        }

        int max_cnt = max;
        int comp = arr[max_idx] + 1;
        for(int i = max_idx; i>=0;i--){
            if(dp[i] == max && comp > arr[i]){
                stack.add(arr[i]);
                max--;
                comp = arr[i];
            }
        }

        System.out.println(max_cnt);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        dp[0] = 1;

        stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}