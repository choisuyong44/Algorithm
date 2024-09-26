import java.io.*;
import java.util.*;

public class Solution {


	static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			long ans = 0;

			N = Long.parseLong(br.readLine());

			if (N == 2) ans = 0;
			else {
				while(N>2) {
					if(Math.sqrt(N)%1.0==0) {
						ans++;
						N = (long)Math.sqrt(N);
					}
					else {
						ans+= Math.pow((long)Math.sqrt(N)+1,2) - N;
						N = (long)Math.pow((long)Math.sqrt(N)+1,2);
					}
					if(N==2) break;
				}
			}

			sb.append("#").append(T).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}