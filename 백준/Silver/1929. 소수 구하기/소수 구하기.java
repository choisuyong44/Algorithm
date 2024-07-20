import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		
		boolean[] primeTable = new boolean[1000001];
		
		primeTable[0] = true;
		primeTable[1] = true;
		
		// 1000000 백만 * 1000 -> 1억번 연산
		for (int i = 2; i < (int) (Math.sqrt(primeTable.length)) + 1; i++) {
			if(primeTable[i]==true)continue;
			for (int j = 2*i; j < 1000001; j++) {
				if (j % i == 0) {
					primeTable[j] = true;
				}
			}
		}

		for (int i = M; i <= N; i++) {
			if (primeTable[i] == false)
				System.out.println(i);
		}
	}
}