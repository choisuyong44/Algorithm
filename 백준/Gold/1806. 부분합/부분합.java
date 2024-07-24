import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];
		int length = Integer.MAX_VALUE;

		// 1만번 -> 1억
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int start = 0;
		int end = 0;
		int flag = 0;
		
        while(start <= N && end <= N) {
            if(sum >= S && length> end - start) length = end - start;
            
            if(sum < S) sum += arr[end++];
            else sum -= arr[start++];
        }
        if(length ==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(length);
	}

}