import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		
		String[] nArr = new String[n];
		String[] mArr = new String[m];
	
		for(int i =0;i<n;i++) {
			nArr[i] = br.readLine();
		}
		
		for(int i  =0;i<m;i++) {
			mArr[i] = br.readLine();
		}
		
		int cnt  =0;
		
		for(int i =0;i<n;i++) {
			for(int j =0;j<m;j++) {
				if(nArr[i].equals(mArr[j])) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}