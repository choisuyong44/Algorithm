import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Long[]> q = new LinkedList<>();
		Set<Long> set = new HashSet<>();

		Long N = sc.nextLong();

		q.add(new Long[] { N, (long) 0 });
		set.add(N);

		while (true) {

			Long[] k = q.poll();

			if (k[0] == 1) {
				System.out.println(k[1]);
				return;
			}

			if (k[0] % 3 == 0 && !set.contains(k[0] / 3)) {
				set.add(k[0] / 3);
				q.add(new Long[] { k[0] / 3, k[1] + 1 });
			}

			if (k[0] % 2 == 0 && !set.contains(k[0] / 2)) {
				set.add(N / 2);
				q.add(new Long[] { k[0] / 2, k[1] + 1 });
			}

			if (!set.contains(k[0] - 1)) {
				set.add(k[0] - 1);
				q.add(new Long[] { k[0] - 1, k[1] + 1 });
			}
		}
	}
}