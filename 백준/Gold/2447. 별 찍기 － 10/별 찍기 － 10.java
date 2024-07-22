import java.io.*;
import java.util.*;

import javax.xml.stream.events.StartDocument;

public class Main {
	static char[][] starBoard;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				starboxMaker(i, j, N);
			}
			sb.append("\n");
		}
        		System.out.println(sb);
	}

	static void starboxMaker(int row, int col, int N) {
		if ((row / N) % 3 == 1 && (col / N) % 3 == 1) {
			sb.append(" ");
		} else {
			if (N / 3 == 0) {
				sb.append("*");
			} else {
				starboxMaker(row, col, N / 3);
			}
		}
	}
}