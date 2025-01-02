import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static Map<Integer,Integer> map = new HashMap(); 
    public int solution(int[] nums) {
        int answer = 0;
        N = nums.length;
        for(int i =0;i<N;i++){
            if(!map.containsKey(nums[i])){
                answer++;        
                map.put(nums[i],1);
            }
        }
        answer = Math.min(N/2,answer);
        return answer;
    }
}