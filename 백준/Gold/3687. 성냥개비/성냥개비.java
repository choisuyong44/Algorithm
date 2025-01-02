import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/*
 * 접근 방법 :
 * 1. 2^50 -> 10^50 자리까지 max는 7이랑 1이용해서 대충 처리
 * 	min에 대해서 해결
 * 
 * 2. testcase 100 개 -> 미리 table에다가 기록해두면 좋겠다.
 * 1 : 2,  2 : 5,  3 : 5,  4 : 4,  5 : 5, 
 * 6 : 6,  7 : 3,  8 : 7,  9 : 6,  0 : 6
 */
public class Main {
	static Stack<Integer> s = new Stack<>();
	static int n;
	static long small,big;
	static long[] min;
	static int [] arr= {1,7,4,2,0,8};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		min = new long[101];
		Arrays.fill(min, Long.MAX_VALUE);
		min[2] = 1; min[3] =7; min[4] = 4; min[5] = 2;
		min[6] = 6; min[7] =8; min[8] = 10;
		
		// 2개를 더해야 가장 작은 수가 나온다.
		for(int i = 9;i<=100;i++) {
			for(int j = 2;j<=7;j++) {
	             String temp = String.valueOf(min[i-j])+String.valueOf(arr[j-2]);
	             min[i] = Math.min(Long.parseLong(temp),min[i]);  
			}	 
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<T;tc++) {
			n = Integer.parseInt(br.readLine());
			sb.append(min[n]).append(" ");
			while(n>0) {
				if(n==3) {
					s.add(7);
					n -= 3;
				}
				else {
					s.add(1);
					n-=2;
				}
				
			}
			while(!s.isEmpty()) {
				sb.append(s.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}