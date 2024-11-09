import java.io.*;
import java.util.*;

public class Main {
	// 이건 투포인터다
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cntNumber = new int[100_001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 중복없을 떄까지 추가해서 더하기
		int start = 0; int end = 0;long ans = 0;
		while(true) {
			if(end>=N) {
				break;
			}
			
			else if(cntNumber[arr[end]]==0) {
				cntNumber[arr[end]]++;
				ans += end-start+1;
				end++;
			}
			
			else {
				cntNumber[arr[start]]--;
				start++;
			}
		}
		
		System.out.println(ans);
	}
	
	
}