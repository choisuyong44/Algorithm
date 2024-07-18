import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
	
		/*
		 * 
		 * hashMap key : value
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		Map<Integer,Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		
		int k; int v;
		for(int i =0 ;i<N;i++) {
			k = Integer.parseInt(st.nextToken());
			
			// 없는 경우
			if (map.get(k) == null) {
				map.put(k, 1);
			}
			
			else {
				v= map.get(k);
				map.put(k, v+1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<M;i++) {
			k = Integer.parseInt(st.nextToken());
		
			// 없는 경우
			if (map.get(k) == null) {
				sb.append("0 ");
			}
			
			// 있는 경우
			else {
				sb.append(map.get(k)+" ");
			}
		}
		
		System.out.println(sb);
	}
}