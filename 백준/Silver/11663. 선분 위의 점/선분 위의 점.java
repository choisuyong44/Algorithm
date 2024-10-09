import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int N,M;
	static List<Integer> list;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i =0;i<M;i++) {
			ans =0;
			st = new StringTokenizer(br.readLine());
			cntPoint(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void cntPoint(int low, int high) {
		ans = findMaxIdx(high)-findMinIdx(low)+1;
	}
	
	public static int findMinIdx(int target) {
		int low = 0; int high = arr.length;
		while(low<high) {
			int mid = (low+high)/2;
			if(target <= arr[mid]) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return low;
	}
	
	public static int findMaxIdx(int target) {
		int low = 0; int high = arr.length;
		while(low<high) {
			int mid = (low+high)/2;
			if(target >= arr[mid]) {
				low = mid+1;
			}
			else {
				high = mid;
			}
		}
		return low-1;
	}
}