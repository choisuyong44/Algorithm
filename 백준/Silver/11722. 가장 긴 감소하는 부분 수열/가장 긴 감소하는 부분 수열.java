import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr,dp;
    public static void main(String[] args) throws IOException {
        input();
        if(N==1) {
            System.out.println(1);
            return;
        }
        int max =0;
        for (int i = N-2; i >=0; i--) {
            int cnt = 0;
            for(int j = 1; i+j<N;j++){
                if(arr[i] > arr[i+j]){
                    cnt = Math.max(cnt, dp[i+j]);
                }
            }
            dp[i] = cnt+1;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        dp[N-1] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}