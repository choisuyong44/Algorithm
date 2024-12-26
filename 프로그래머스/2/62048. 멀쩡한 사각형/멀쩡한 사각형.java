import java.io.*;
import java.util.*;

class Solution {
    static long k;
    public long solution(int w, int h) {
        long answer = (long)w*h;
        
        // 최대공약수 구하기
        k = gcd(w,h);
        
        // 가로세로 비율구하기
        long sub = (w / k) + (h / k) - 1;
        
        // answer = answer - 
        // ( 최대공약수를 만드는 사각형 ex) 2*3 중에 잘라지는 부분 * 최대 공약수) 
        answer -= sub*k;
        return answer;
    }
    
    public static long gcd(int w,int h){
        if(w%h==0) return h;
        return gcd(h,w%h);
    }
    
}