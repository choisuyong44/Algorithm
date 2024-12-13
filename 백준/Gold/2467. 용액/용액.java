import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] water;
	
	public static void main(String[] args) throws IOException{
		input();
		int left = 0; int right = N-1;
		int A = water[left]; int B = water[right];
		int value = A+B;
		
		while(left < right) {
			if(Math.abs(value) > Math.abs(water[left]+water[right])) {
				A = water[left]; B = water[right];
				value = A+B;
			}
			
			if(water[left]+water[right] > 0) right--;
			else if (water[left]+water[right] < 0) left++;
			else break;
		}
		
		System.out.println(A + " " + B);
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		water = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
	}
}