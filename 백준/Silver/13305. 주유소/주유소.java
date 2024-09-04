import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] city;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		dist = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		// city
		city = new int[N];
		
		// city 첫번째 값
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		city[0] = k;
		
		// 나머지 값 받기 나보다 비싸면 -1
		for(int i=1;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			// 나보다 비싸면 -1로 set
			if(k < tmp) {
				city[i] = -1;
			}
			// 나보다 비싸면 
			else {
				city[i] = tmp;
				k = tmp;
			}
		}
		
		long sum_cost = 0;
		int min_cost = city[0];
		int now =0;
		while(true) {
			// 도착했다면?
			if(now == city.length-1) break;
			
			// 유효한 기름값이라면
			if(city[now] !=-1) {
				min_cost = city[now];
			}
			
			sum_cost += min_cost*dist[now];
			now++;
		}
		
		System.out.println(sum_cost);
	}
	
}