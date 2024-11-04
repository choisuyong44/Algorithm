import java.io.*;
import java.util.*;

/*
* 순서대로 n개의 퍼즐을 제한 시간 내에 풀어야하는 퍼즐 게임
* 난이도와 소요 시간 정해져 있음 -> 숙련도에 따라 퍼즐을 풀 때 틀리는 횟수가 바뀜
* 현재 퍼즐의 난이도 diff, 현재 소요시간 time_cur, 이전 퍼즐 소요시간 time_prev, 숙련도 level
* 현재 난이도 <= 숙련도 -> time_cur 만큼 소요
* 현재 난이도 > 숙련도 -> diff-level 번 틀림 -> time_cur + (time_cur+ prev)*(diff-level)
* 틀릴 때마다 time_prev 만큼의 시간 사용 + 이전 퍼즐 만큼 시간 추가(이전 퍼즐은 무조건 맞춤)
* 난이도 - level 번 틀리고 보너스 느낌으로 time_cur으로 해결
* limit -> 숙련도의 최솟값 lower bound
* 이진탐색 -> 
*/
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int min = 1; int max = 1; int mid;
        for(int i =0;i<diffs.length;i++){
            max = Math.max(max,diffs[i]);
        }
        
        while(min < max){
            mid = (min+max)/2;
            // 시간 초과 발생 -> 능력 증가
            if(countTime(mid,diffs,times) > limit){
                min = mid+1;
            }
            else{
                max = mid;
            }
        }
        answer = min;
        return answer;
    }
    
    public static long countTime(int level, int[] diffs, int[] times){
        long time = 0;
        for(int i = 0;i<diffs.length;i++){
            if(level >= diffs[i]) {
                time += times[i];
            }else {
                    time += (times[i]+times[i-1])*(diffs[i]-level)+ times[i];
            }
        }
        return time;
    }
}