import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
- idx : 0 1 2 3 4 5 6 7 ...
- col++ -> row 2개 중 하나 고르거나 pass
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] dp;
    static byte[][] arr;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            input();
            dp = new int[3][N];
            dp[0][0] = 0;            // 0. 아무것도 안고르는 경우
            dp[1][0] = arr[0][0];    // 1. 0 번 인덱스 고르기
            dp[2][0] = arr[1][0];    // 2. 1 번 인덱스 고르는 경우

            for(int i =1;i<N;i++) {
                dp[0][i] = Math.max(dp[1][i-1],dp[2][i-1]);
                dp[1][i] = Math.max(dp[0][i-1],dp[2][i-1])+arr[0][i];
                dp[2][i] = Math.max(dp[0][i-1],dp[1][i-1])+arr[1][i];
            }

            int ans = Math.max(dp[0][N-1],dp[1][N-1]);
            ans = Math.max(ans,dp[2][N-1]);
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new byte[2][N];

        for(int i =0;i<2;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = (byte)Integer.parseInt(st.nextToken());
            }
        }
    }
}