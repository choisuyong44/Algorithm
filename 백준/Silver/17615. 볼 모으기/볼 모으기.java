import java.io.*;
import java.util.*;

public class Main {
	
	static int N,min;
	static String ball;
	
	public static void main(String[] args) throws IOException{
		Scanner sc= new Scanner(System.in);
		
		// 4가지 경우
		// 왼쪽/ 오른쪽으로 R 모으기 - R를 옮기는 경우
		// 왼쪽/ 오른쪽으로 B 모으기 - B를 옮기는 경우
		
		int cnt; boolean letsGoCount;
		min = Integer.MAX_VALUE;
		N = sc.nextInt();
		ball = sc.next();
		
		// 1. 왼쪽으로 R 옮기기
		// B 이후에 있는 R카운트
		letsGoCount=false; cnt= 0;
		for(int i =0;i<N;i++) {
			if(letsGoCount && ball.charAt(i)=='R')cnt++;
			if(ball.charAt(i)=='B') letsGoCount = true; 
		}
		min = Math.min(cnt, min);
		
		// 2. 오른쪽으로 R 옮기기
		// B 이전에 있는 R카운트
		letsGoCount=false; cnt= 0;
		for(int i =N-1;i>=0;i--) {
			if(letsGoCount && ball.charAt(i)=='R')cnt++;
			if(ball.charAt(i)=='B') letsGoCount = true; 
		}
		min = Math.min(cnt, min);
		
		// 3. 왼쪽으로 B 옮기기
		// R 이후에 있는 B카운트
		letsGoCount=false; cnt= 0;
		for(int i =0;i<N;i++) {
			if(letsGoCount && ball.charAt(i)=='B')cnt++;
			if(ball.charAt(i)=='R') letsGoCount = true; 
		}
		min = Math.min(cnt, min);
		
		// 4. 오른쪽으로 B 옮기기
		// R 이전에 있는 B카운트
		letsGoCount=false; cnt= 0;
		for(int i =N-1;i>=0;i--) {
			if(letsGoCount && ball.charAt(i)=='B')cnt++;
			if(ball.charAt(i)=='R') letsGoCount = true; 
		}
		min = Math.min(cnt, min);
	
		System.out.println(min);
	}
}