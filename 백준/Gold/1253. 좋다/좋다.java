import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int cnt =0;
		
		// i를 하나씩 탐색
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (start ==i) start++;
                else if(end==i) end--;
                else {
                    int now = arr[start] + arr[end];
                    if (arr[i] == now) {cnt++;break;} 
                    else if (now < arr[i]) start++;
                    else end--;
                }
            }
        }

		System.out.println(cnt);
	}
}