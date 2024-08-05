import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> answerList = new ArrayList<Integer>();
        
        int[] remainDays= new int[progresses.length];
        		
		for(int i =0;i<progresses.length;i++) {
            
if((100-progresses[i])%speeds[i] ==0) {
				remainDays[i] = (100-progresses[i])/speeds[i];
			}
            
			else {
				remainDays[i] = (100-progresses[i])/speeds[i] +1;
			}
		}
        
        int max = remainDays[0];
		int cnt =1; // max 포함
        
		for(int i=1;i<remainDays.length;i++) {
			if(max >= remainDays[i]) {
				cnt++;
			}
			else {
				answerList.add(cnt);
				cnt = 1;
				max = remainDays[i];
			}
		}
		answerList.add(cnt);
		
        answer = new int[answerList.size()];
		for(int i =0;i<answerList.size();i++) {
			answer[i] = answerList.get(i);
		}
        return answer;
    }
}