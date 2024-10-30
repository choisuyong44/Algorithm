import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N일 동안 쓸 금액 계산
 * M번만 통장에서 돈을 뻄
 * M번 뺼때 K만큼만 뺌
 * 만약 돈이 모자라면 새로 K만큼꺼낸다
 */
public class Main {

	static int N,M,max,min;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		max =0;min = 0;
		arr = new int[N];
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			min = Math.max(arr[i], min);
			max += arr[i];
		}
		
		// 최소 1원 최대 arr[i]중 max+1
		int left = min; int right = max;
		
		while(left<right) {
			int mid = (left+right)/2;
			int k = countM(mid);
			if(k > M) {
				left = mid+1;
			}
			else right = mid-1;
		}
		
		System.out.println(left);
	}
	
	public static int countM(int money) {
		// money 한번에 인출가능한 금액
		int cnt =1; int rest = money;
		for(int i =0;i<N;i++) {
			if(rest - arr[i] < 0) {
				rest = money - arr[i];
				cnt++;
			}
			else rest -= arr[i];
		}
		return cnt;
	}
}