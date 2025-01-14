import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static boolean[] visited;
    static int[][] computer;
    static Queue<Integer> q;
    public int solution(int n, int[][] computers) {
        N = n; 
        int ans = 0;
        computer = computers;
        visited = new boolean[N];
        for(int i =0;i<N;i++){
            if(visited[i]) continue;
            bfs(i);
            ans++;
        }
        return ans;
    }
    
    public static void bfs(int start){
        q  = new LinkedList();
        q.add(start); visited[start] = true;
        while(!q.isEmpty()){
            int k = q.poll();
            
            for(int i =0;i<N;i++){
                if(!visited[i] && computer[k][i]==1){
                    q.add(i);
                    visited[i] = true;
                }   
            }
        }
    }
}