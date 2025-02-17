import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 2; // 이긴 사람 : CY
        dp[2] = 1; // 이긴 사람 : SK
        dp[3] = 2; // 이긴 사람 : CY
        for(int i =4;i<N+1;i++){
            if(dp[i-1]==2){
                dp[i] = 1;
            } 
            else dp[i] = 2;
        }
        if(dp[N]==1) System.out.print("SK");
        else System.out.print("CY");
    }
}