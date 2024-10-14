import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<int[]> pq;
    
    public int solution(int[][] targets) {
        int answer=0; 
        pq = new PriorityQueue<int[]>((o1, o2) ->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        
        for(int[] i : targets){
            pq.add(i);
        }
        
        int end =0;
        while(!pq.isEmpty()){
            // start가 end가 뒤인 경우
           int[] k = pq.poll();
           if(end<=k[0]){
               end = k[1];
               answer++;
                continue;
           }
           end = Math.min(end,k[1]);
        }
        
        return answer;
    }
}