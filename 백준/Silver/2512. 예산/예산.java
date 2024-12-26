import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소 1
// 최대 가장 큰 예산 요청

// pseudo
// binary-search
// 전체 예산보다 크면 예산 중간값
// 전체 예산보다 작으면 중간값
public class Main {

	static int N,max =0 ,min=0,mid,K;
	static int[] req;
	public static void main(String[] args) throws IOException{
		input();
		binarySearch();
	}
	
	public static void binarySearch() {
		while(min<max) {
			mid = (min+max)/2;
			if(calMoney(mid) > K) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
	}
	
	public static int calMoney(int k) {
		int sum =0;
		for(int i =0 ;i<N;i++) {
			if(k>req[i]) sum += req[i];
			else sum +=k;
		}
		return sum;
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		req = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			req[i] = Integer.parseInt(st.nextToken());
			max = Math.max(req[i], max);
		}
		K = Integer.parseInt(br.readLine());
		max++;
	}
}