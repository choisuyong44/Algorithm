import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] parent;
    static int N;
    static Map<Integer,Integer> map = new HashMap();
    
    public int solution(int[] cards) {
        // parent에 cards 복사
        N = cards.length;
        parent = new int[N+1];
        visited = new boolean[N+1];
        for(int i =0;i<N;i++){
            parent[i+1] = cards[i];
        }
        
        // dfs
        for(int i =1;i<N+1;i++){
            if(visited[i]) continue;
            dfs(i,i);
        }
        
        // map에 저장
        for(int i =1;i<N+1;i++){
            if(!map.containsKey(parent[i])) map.put(parent[i],1);
            else map.put(parent[i],map.get(parent[i])+1);
        }
        
        int answer = 0;
        for(int i =1;i<N;i++){
            for(int j =i+1;j<N+1;j++){
                if(parent[i]==parent[j]) continue;
                answer = Math.max(map.get(parent[i])*map.get(parent[j]) , answer);
            }   
        }

        return answer;
    }
    
    public static void dfs(int origin, int i){
        if(visited[i]) return;
        visited[i] = true;
        dfs(origin, parent[i]);
        parent[i] = origin; 
    }
}