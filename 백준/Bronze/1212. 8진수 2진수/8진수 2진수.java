import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		if(s.length() ==1 && s.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		int[] arr = new int[3];
		int n = s.charAt(0);
		
		for(int i =2;i>=0;i--) {
			arr[i] = n%2;
			n/=2;
		}
		
		int flag =0;
		for(int i =0;i<3;i++) {
			if(arr[i] ==0 &&flag==0) {
				continue;
			}
			else {
				sb.append(arr[i]);
				flag =1;
			}
		}
		
		
		for(int i = 1;i<s.length();i++){
			change(s.charAt(i)-'0');
		}
		
		System.out.println(sb);
	}

	public static void change(int i) {

		switch (i) {
		case 0:
			sb.append("000");
			break;
		case 1:
			sb.append("001");
			break;
		case 2:
			sb.append("010");
			break;
		case 3:
			sb.append("011");
			break;
		case 4:
			sb.append("100");
			break;
		case 5:
			sb.append("101");
			break;
		case 6:
			sb.append("110");
			break;
		case 7:
			sb.append("111");
			break;
		}
	}
}