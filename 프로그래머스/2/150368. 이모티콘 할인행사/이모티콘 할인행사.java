import java.io.*;
import java.util.*;

class Solution {
    static int N,M;
    static int[][] users_copy;
    static int[] emoticons_copy, sale,answer;
    public int[] solution(int[][] users, int[] emoticons) {
        N = users.length; M = emoticons.length;
        users_copy = users;
        emoticons_copy = emoticons;
        sale = new int[M];
        answer = new int[2];
        dfs(0);
        return answer;
    }
    
    static void dfs(int depth){
        if(depth==M){
            simulate();
            return;
        }
        for(int i =10;i<=40;i+=10){
            sale[depth] = i;
            dfs(depth+1);
        }
    }
    
    static void simulate(){
        int subscribe =0;int sale_count =0;
        // user
        out : for(int i =0;i<N;i++){
            int money = 0;
            
            // emoticons
            for(int j =0;j<M;j++){
                // 더 세일을 많이 할 때,
                if(users_copy[i][0] <= sale[j]){
                    money += ((100-sale[j]) * emoticons_copy[j] / 100);
                }
                // 예상금액보다 돈이 더 많이 나왔을 떄,
                if(money >= users_copy[i][1]) {
                    subscribe++;
                    continue out;
                }
            }
            // 모두 구매가능할 때
            sale_count+=money;
        }
        
        if(answer[0] < subscribe){
            answer[0] = subscribe;
            answer[1] = sale_count;
        }
        
        else if(answer[0] == subscribe){
            if(answer[1] <= sale_count){
                answer[0] = subscribe;
                answer[1] = sale_count;    
            }
        }
    }
}