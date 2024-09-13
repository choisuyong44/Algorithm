import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[] lecture;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lecture = new int[N];
		st = new StringTokenizer(br.readLine());
		long max =0; long min = 0;
		for(int i =0;i<N;i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			min = Math.max(min, lecture[i]);
			max += lecture[i];
		}
		
		binarySearch(min, max+1);
	}
	
	public static void binarySearch(long min, long max) {
		long mid =0; int n =0;
		
		while(min <= max) {
			// mid는 블루레이의 길이
			mid = (min+max)/2;
			
			long tmp = mid;
			n =1;
			for(int i =0;i<N;i++) {
				tmp -= lecture[i];
				
				if(tmp < 0) {
					tmp =mid;
					n++;
					i--;
				}
			}
			
			// 블루레이 갯수 비교
			if(n > M) {
				min = mid+1;
			}
			
			else {
				max = mid-1;
			}
		}
		System.out.println(min);
	}
}