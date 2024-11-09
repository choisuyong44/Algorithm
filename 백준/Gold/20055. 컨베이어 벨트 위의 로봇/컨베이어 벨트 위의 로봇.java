import java.io.*;
import java.util.*;

public class Main {

	static int N,K;
	static int[] belt;
	static boolean[] robot;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[N*2];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<2*N;i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int time =0;
		while(!isStop()) {
			// 1. 컨베이어와 로봇 이동
			// 1-1. 컨베이어 이동
			int start = belt[2*N-1]; 
			for(int i = 2*N-1;i>0;i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = start;
			// 1-2. 로봇 이동
			for(int i =N-1;i>0;i--) {
				if(robot[i-1]) {
					robot[i-1]= false;
					robot[i] = true;
				}
			}
			if(robot[N-1]) robot[N-1] = false;
			
			// 2. 로봇 이동
			for(int i = N-1;i>0;i--) {
				// 1. 내구도 && 로봇 이동할 곳 존재 && 현재 존재 여부 검사
				if(belt[i]>0 && !robot[i] && robot[i-1]) {
					robot[i-1] = false;
					robot[i] = true;
					belt[i]--;
				}
			}
			
			if(robot[N-1]) robot[N-1] = false; 
			
			// 3. 로봇 올리기
			if(belt[0]>0) {
				robot[0] = true;
				belt[0]--;
			}
			
			time++;
		}
		
		System.out.println(time);
	}
	
	public static boolean isStop() {
		int cnt=0;
		for(int i =0;i<2*N;i++) {
			if(belt[i]<=0)cnt++; 
		}
		return cnt>=K;
	}
}