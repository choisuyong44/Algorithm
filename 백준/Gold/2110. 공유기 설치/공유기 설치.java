import java.io.*;
import java.util.*;

public class Main {

	static int N,C;
	static int[] house;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		C = sc.nextInt();
		
		house = new int[N];
		
		// 집에 공유기가 하나씩 달려있는 경우가 최소 거리
		int min = 1;
		
		// 첫 집과 가장 끝 집에 달려있는 경우가 최대 거리
		for(int i =0;i<N;i++) {
			house[i] = sc.nextInt();
		}
		
		Arrays.sort(house);
		
		binarySearch(min, house[N-1]-house[0]+1);
	}
	
	public static void binarySearch(int min,int max) {
		int mid =0;
		while(min < max) {
			
			mid = (min+max)/2;
			
			if(countRouter(mid) < C ) {
				max = mid;
			}
			
			else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
	}
	
	public static int countRouter(int dist) {
		int cnt =1;
		int base = house[0];
		
		for(int i =0;i<house.length;i++) {
			if(house[i]-base >= dist) {
				base = house[i];
				cnt++;
			}
		}
		
		return cnt;
	}
}