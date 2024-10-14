import java.io.*;
import java.util.*;

public class Main {
	
    static int n; // 사탕 종류 수
    static int m; // 상근이가 가진 돈의 양
    static StringBuilder sb = new StringBuilder();
    static int[] dp;

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            float tempM = Float.parseFloat(st.nextToken());

            if (n == 0 && tempM == 0.00) {
                System.out.println(sb);
                return;
            }
            
            m = (int) (tempM * 100 + 0.5);
            
            dp = new int[m+1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int calorie = Integer.parseInt(st.nextToken());
                int money = (int) (Float.parseFloat(st.nextToken()) * 100.0 + 0.5);

                for (int j = 0; j <= m; j++) {
                    if (j - money >= 0) dp[j] = Math.max(dp[j], dp[j-money] + calorie);
                }
            }

            sb.append(dp[m]).append("\n");
        }
	}
}