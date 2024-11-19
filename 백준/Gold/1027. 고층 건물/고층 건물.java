import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int N,ans;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.next());
		arr = new int[N];
		
		for(int i =0;i<N;i++) {
			arr[i] = sc.nextInt();
		}

		if(N<=3) {
			System.out.println(N-1);
			return;
		}
		
		ans =0;
		for(int i =0;i<N;i++) {
			int cnt =0;
			
			// i에서 출발, 기울기가 점점 감소해야함
			double slope = 1_000_000_000.1;
			for(int left = i-1;left>=0;left--) {
				double new_slope = calIncline(i, arr[i], left,arr[left]);
				if(new_slope >= slope) continue;
				cnt++;
				slope = new_slope;
			}
			
			// 기울기가 점점 증가해야함
			slope = -1_000_000_000.1;
			for(int right = i+1;right<N;right++) {
				double new_slope = calIncline(i, arr[i], right, arr[right]);
				if(new_slope <= slope) continue;
				cnt++;
				slope = new_slope;
			}
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
	
	public static double calIncline(double x2, double y2, double x1, double y1) {
		return (y1-y2)/(x1-x2);
	}
}