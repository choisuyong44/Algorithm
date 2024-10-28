import java.io.*;
import java.util.*;

/*
>> 실수
1. O를 표시해야 하는 데, X를 표시
2. 끝나야 하는 데, 안 끝나는 경우
*/

class Solution {
    
    public int solution(String[] board) {
        int answer = 1;
        int Ocount = 0; int Xcount = 0;
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                if(board[i].charAt(j)=='O') Ocount++;
                if(board[i].charAt(j)=='X') Xcount++;
            }
        }
        
        // 1. O가 X+1보다 큰 경우
        if(Ocount > Xcount +1) return 0; 
        
        // 2. X가 O보다 큰 경우
        if(Ocount < Xcount) return 0;
        
        // 3. X의 공격으로 끝난 경우
        if(Ocount==Xcount){
            if(isBingo(board,'O') &&isBingo(board,'X'))return 0;
            if(isBingo(board,'O')) return 0;
        }
        
        // 4 O의 공격으로 끝난 경우
        if(Ocount==Xcount+1){
            if(isBingo(board,'O') &&isBingo(board,'X'))return 0;
            if(isBingo(board,'X')) return 0;
        }
        
        return answer;
    }
    
    public static boolean isBingo(String[] board, char c){
        // 가로
        out : for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                if(board[i].charAt(j)!=c) continue out;
            }
            return true;
        }
        
        // 세로
        out: for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                if(board[j].charAt(i)!=c) continue out;
            }
            return true;
        }
        
        // 대각선 \
        if(board[0].charAt(0) == board[1].charAt(1) 
           && board[1].charAt(1) == board[2].charAt(2)
           && board[0].charAt(0) ==c) return true;
        
        // 대각선 /
        if(board[2].charAt(0) == board[1].charAt(1) 
           && board[1].charAt(1) == board[0].charAt(2)
           && board[2].charAt(0) ==c) return true;
        
        return false;
    }
}