import java.io.*;
import java.util.*;

/*
 * 입장 : 
 * 1. 개강총회시작 시간 이전에 대화한 적이 있는 학회원
 * 2. 개강총회 시작하자마자 채팅남긴 회원
 * 00:00<= 시작시간까지
 * 
 * 퇴장 :
 * 1. 개강총회 끝 <= 스트리밍이 끝날떄까지 
 */
public class Main {

	static Map<String,Integer> map;
	static int time;
	static String input,name;
	static int start,end, quit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringTokenizer divideTime;
		
		start = end = quit = 0;
		map = new HashMap<String, Integer>();
		
		// start, end ,quit
		st = new StringTokenizer(br.readLine());
		divideTime = new StringTokenizer(st.nextToken() , ":");
		start += 60*Integer.parseInt(divideTime.nextToken());
		start += Integer.parseInt(divideTime.nextToken());
		divideTime = new StringTokenizer(st.nextToken() , ":");
		end += 60*Integer.parseInt(divideTime.nextToken());
		end += Integer.parseInt(divideTime.nextToken());
		divideTime = new StringTokenizer(st.nextToken() , ":");
		quit += 60*Integer.parseInt(divideTime.nextToken());
		quit += Integer.parseInt(divideTime.nextToken());
	
		int cnt =0;
		input ="";
		while(true ) {
			input = br.readLine();
			if(input ==null || input.trim().isEmpty()) break;
			time = 0;
			st = new StringTokenizer(input);
			divideTime = new StringTokenizer(st.nextToken() , ":");
			time += 60*Integer.parseInt(divideTime.nextToken());
			time += Integer.parseInt(divideTime.nextToken());
			name = st.nextToken();
			
			// 시작인원 체크
			if (time <=start) {
				map.put(name,1);
			}
			
			// 종료인원 체크
			if (end <= time && time <= quit) {
				// 이미 키가 있을 떄
				if(map.containsKey(name) && map.get(name)==1) {
					map.put(name, 0);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}	
}