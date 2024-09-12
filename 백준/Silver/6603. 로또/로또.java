import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visit;
	static int[] arr;
	static int[] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			if(k ==0) {
				return;
			}
			
			else {
				arr = new int[k];
				visit = new boolean[k];
				for(int i =0;i<k;i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				
				ans = new int[6];
				perm(0,0);
				System.out.println();
			}
		}
	}
	
	public static void perm(int idx,int cnt) {
		if(cnt == 6) {
			for(int i =0;i<ans.length;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i =idx;i<arr.length;i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[cnt] = arr[i];
				perm(i+1,cnt+1);
				visit[i] = false;
			}
		}
	}
}