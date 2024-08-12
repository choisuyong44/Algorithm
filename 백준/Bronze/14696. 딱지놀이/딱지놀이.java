import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] card = new int[2][5];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int tmp;
		out : for(int i =0;i<N;i++) {
			card[0] = new int[5];
			card[1] = new int[5];
			
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				card[0][Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				card[1][Integer.parseInt(st.nextToken())]++;
			}
			
			// compare
			
			for(int j =4;j>=1;j--) {
				if(card[0][j]> card[1][j]) {
					System.out.println("A");
					continue out;
				}
				else if(card[0][j]< card[1][j]) {
					System.out.println("B");
					continue out;
				}
			}
			System.out.println("D");
		}
	}
}