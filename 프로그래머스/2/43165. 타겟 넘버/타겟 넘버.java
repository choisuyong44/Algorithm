import java.io.*;
import java.util.*;

class Solution {
    static int N, T, answer;
    static int[] nums;
    static boolean[] isPlus;
    public int solution(int[] numbers, int target) {
        // init()
        answer = 0;
        nums = numbers;
        N = numbers.length; 
        T = target;
        isPlus = new boolean[N];
        
        // dfs()
        dfs(0);
        return answer;
    }
    
    static void dfs(int depth){
        if(depth == N){
            if(cal())answer++;
            return;
        }  
        
        isPlus[depth] = false;
        dfs(depth+1);
        isPlus[depth] = true;
        dfs(depth+1);
    }
    
    static boolean cal(){
        int sum  =0;
        
        for(int i =0;i<N;i++){
            if(isPlus[i]) sum+= nums[i];
            else sum -= nums[i];
        }
        return sum==T;
    }
}