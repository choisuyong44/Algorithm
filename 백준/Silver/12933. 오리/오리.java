import java.io.*;
import java.util.*;

public class Main {

	// q u a c k 순 -> 앞에꺼보다 크면 안됨
	static int[] quackCheck = new int[5];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		int cnt = 0; int max=0;
		// 1. 예외 처리
		// 1 ) 갯수가 다른 경우
		// 2 ) 순서가 다른 경우
		for(int i =0;i<s.length();i++) {
			char sound = s.charAt(i);
			
			switch (sound) {
			case 'q':
				cnt++;
				quackCheck[0]++;
				break;
			case 'u':
				quackCheck[1]++;
				break;
			case 'a':
				quackCheck[2]++;
				break;
			case 'c':
				quackCheck[3]++;
				break;
			case 'k':
				cnt--;
				quackCheck[4]++;
				break;
			}
			
			if(quackCheck[0] >= quackCheck[1] && quackCheck[1] >= quackCheck[2]
					&& quackCheck[2] >= quackCheck[3] && quackCheck[3] >= quackCheck[4]) {
				max = Math.max(max, cnt);
			}
			else {
				System.out.println(-1);
				return;
			}
		}
		
		if(quackCheck[0] == quackCheck[1] && quackCheck[1] == quackCheck[2]
				&& quackCheck[2] == quackCheck[3] && quackCheck[3] == quackCheck[4]) {
			System.out.println(max);
		}
		else {
			System.out.println(-1);
			return;
		}

	}

}