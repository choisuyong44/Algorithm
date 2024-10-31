import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, C;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// Upper Bound 
		Arrays.sort(arr);
		int min = 1; int max = arr[N-1]-arr[0]+1;
		while(min < max) {
			int mid = (min+max)/2;
			int share = findDist(mid);
			if(share >= C) {
				 min = mid+1;
			}
			else {
				max = mid;
			}
		}
		System.out.println(min-1);
	}
	
	public static int findDist(int dist) {
		int cnt = 1; int base = arr[0];
		for(int i =1;i<N;i++) {
			if(arr[i]-base >= dist) {
				base = arr[i];
				cnt++;
			}
		}
		return cnt;
	}
}