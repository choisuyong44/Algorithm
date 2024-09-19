import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		int N;
		int[] arr;
		for(int T = 1;T<TC+1;T++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			// 배열에 입력
			for(int i =0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 비교
			long sum =0;
			for(int i =0;i<N-1;i++) {
				for(int j =i+1;j<N;j++) {
					sum += gcd(arr[i],arr[j]);
				}
			}
			
			System.out.println(sum);
		}
	}
	
	public static int gcd(int p, int q) {
		int tmp;
		
		while(true) {
			if(q==0) {
				return p;
			}
			if(p%q==0) {
				return q;
			}
			tmp = p;
			p = q;
			q = tmp%q;
		}
	}
}