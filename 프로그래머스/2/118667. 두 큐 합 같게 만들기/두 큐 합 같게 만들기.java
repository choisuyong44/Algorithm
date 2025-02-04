import java.io.*;
import java.util.*;

class Solution {
    static Queue<Integer> q1 = new LinkedList();
    static Queue<Integer> q2 = new LinkedList();
    static long sum1 = 0;
    static long sum2 = 0;
    static int SZ;
    static int answer,tmp;
    public int solution(int[] queue1, int[] queue2) {
        SZ = queue1.length;
        for(int i =0;i<SZ;i++){
            sum1+=queue1[i];
            q1.add(queue1[i]);
        }
        for(int i =0;i<SZ;i++){
            sum2+=queue2[i];
            q2.add(queue2[i]);
        }
        
        answer =0;
        solve();
        
        return answer;
    }
    
    static void solve(){
        for(int i=0;i<100*SZ;i++){
            if(sum1==sum2) return;
            else if(sum1>sum2){
                tmp = q1.poll();
                sum2 += tmp;
                sum1 -= tmp;
                q2.add(tmp);
            }
            else if(sum1<sum2){
                tmp = q2.poll();
                sum1 += tmp;
                sum2 -= tmp;
                q1.add(tmp);
            }
            answer++;
        }
        answer = -1;
        return;
    }
}