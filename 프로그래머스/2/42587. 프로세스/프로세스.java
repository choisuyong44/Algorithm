import java.io.*;
import java.util.*;

class Solution {
    static class Num{
        int n;
        boolean target;
        Num(int n, boolean target){
            this.n=n;
            this.target = target;
        }
    }
    
    static Num p;
    static int[] cnt;
    static int max,k;
    static ArrayDeque<Num> dq = new ArrayDeque();
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        // 배열 생성 및 Deque에 데이터 추가
        cnt = new int[10];
        for(int i =0;i<priorities.length;i++){
            if(location == i){
                dq.addLast(new Num(priorities[i],true));
                cnt[priorities[i]]++;
                continue;
            }
            dq.addLast(new Num(priorities[i],false));
            cnt[priorities[i]]++;
        }
        
        // max 찾기
        max = findMax();
        
        // 계속 빼기
        while(!dq.isEmpty()){
            p = dq.removeFirst();
            if(p.n==max){
                cnt[max]--;
                max = findMax();
                
                if(p.target) break;
                answer++;
            }
            dq.addLast(p);
        }
        return answer;
    }
    
    public static int findMax(){
        for(int i =9;i>0;i--){
            if(cnt[i]!=0) return i;
        }
        return 0;
    }
}