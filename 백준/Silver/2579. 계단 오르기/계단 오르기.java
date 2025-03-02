import java.io.*;

public class Main {

    static int N;
    static int[] dp,arr;
    public static void main(String[] args) throws IOException {
        input();

        // 예외
        if(N<=2){
           if(N==1) System.out.println(arr[1]);
           else System.out.println(arr[1]+arr[2]);
           return;
        }
        
        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for(int i= 3;i<=N;i++){
            dp[i] = Math.max(dp[i],dp[i-2]+arr[i]);
            dp[i] = Math.max(dp[i],dp[i-3]+arr[i-1]+arr[i]);
        }

        System.out.println(dp[N]);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}