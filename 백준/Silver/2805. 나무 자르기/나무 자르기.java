import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Integer[] tree = new Integer[N];
 	
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree,(o1,o2)->{
			return o2-o1;
		});
		
		int sum = 0;
		int height = tree[0];
		int cnt =1;
		while(true) {
			if(M <=sum) {
				System.out.println(height);
				return;
			}
			
			while(cnt<N &&height<=tree[cnt]) {
				cnt++;
			}
			
			height--;
			sum += 1*cnt;
		}
	}
}