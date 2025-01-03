import java.io.*;
import java.util.*;

class Solution {
    static int size,time,idx;
    static List<String> cache;
    public int solution(int cacheSize, String[] cities) {
        time = 0;
        size = cacheSize;
        cache = new ArrayList();
        
        // cache size ==0
        if(cacheSize ==0){
            return 5*cities.length;
        }
        
        for(int i =0;i<cities.length;i++){
            String city = cities[i].toLowerCase();
            insert(city);
        }
        int answer = time;
        return answer;
    }
    
    public static void insert(String city){
        if(!cache.contains(city)){
            // cache 꽉찬 경우
            if(cache.size()==size){
                cache.remove(0);
                cache.add(city);
            }
            // cache 꽉차지 않은 경우
            else{
                cache.add(city);    
            }
            time+=5;
        }
        
        else{
            cache.remove(city);
            cache.add(city);
            time++;
        }
    }
    
    static boolean isSame(String a, String b){
        int a_size = a.length();
        int b_size = b.length();
        if(a_size !=b_size) return false;
        for(int i =0;i<a_size;i++){
            if(a.charAt(i)!=b.charAt(i)) return false;    
        }
        return true;
    }
}