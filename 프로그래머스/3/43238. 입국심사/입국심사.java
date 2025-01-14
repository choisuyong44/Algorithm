import java.io.*;
import java.util.*;

class Solution {
    static long N,min,mid,max,person;
    static int[] time;
    public long solution(int n, int[] times) {
        N = n; time = times; max =0;
        for(int i =0;i<times.length;i++){
            max = Math.max(max,times[i]);
        }
        return search();
    }
    
    static long search(){
        min =1; max = N*max+1;
        while(min<max){
            mid = (min+max)/2;
            person =0;
            for(int t : time){
                person += mid/t;
            }
            // 시간 넘침 mid 감소
            if(person >= N){
                max = mid;        
            }       
            // 시간 부족 mid 증가
            else{
                min = mid+1;
            }
        }
        return min;
    }
}