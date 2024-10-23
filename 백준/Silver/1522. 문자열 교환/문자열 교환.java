import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[] str;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int SZ =0; int N =s.length();
		arr = new int[N];
		str = new char[N*2];
		for(int i =0;i<N;i++) {
			if(s.charAt(i)=='a') SZ++;
			str[i] = str[i+N] = s.charAt(i);
		}
	
		int cnt =0;
		for(int i =0;i<SZ;i++) {
			if(str[i]=='b')cnt++;
		}
		arr[0] = cnt;
		int ans = Integer.MAX_VALUE;
		ans = Math.min(cnt, ans);
		for(int i = 1;i<N;i++) {
			cnt = arr[i-1];
			if(str[i+SZ-1]=='b')cnt++;
			if(str[i-1]=='b')cnt--;
			ans = Math.min(cnt, ans);
			arr[i] = cnt;
		}
		System.out.println(ans);
	}
}