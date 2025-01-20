import java.io.*;
import java.util.*;

class Solution {
    static int[] dp;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList();
    public int solution(int x, int y, int n) {
        dp = new int[y+1];
        visited = new boolean[y+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[x] = 0;
        q.add(x);
        
        while(!q.isEmpty()){
            int k = q.poll();
            
            if(k+n<=y && !visited[k+n]){
                q.add(k+n);
                dp[k+n] = Math.min(dp[k]+1,dp[k+n]);
                visited[k+n] = true;
            }
            
            if(k*2<=y && !visited[k*2]){
                q.add(k*2);
                dp[k*2] = Math.min(dp[k]+1,dp[k*2]);
                visited[k*2] = true;
            }
            
            if(k*3<=y && !visited[k*3]){
                q.add(k*3);
                dp[k*3] = Math.min(dp[k]+1,dp[k*3]);
                visited[k*3] = true;
            }
        }
        
        int answer = 0;
        if(dp[y]==Integer.MAX_VALUE) answer =-1;
        else answer = dp[y];
        return answer;
    }
}